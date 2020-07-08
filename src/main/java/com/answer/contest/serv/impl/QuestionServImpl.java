package com.answer.contest.serv.impl;

import com.answer.contest.dto.QuestionDTO;
import com.answer.contest.entity.*;
import com.answer.contest.mapper.*;
import com.answer.contest.serv.QuestionServ;
import com.answer.contest.vo.AchievementVO;
import com.answer.contest.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dzy
 * @date 2020/6/28
 * @desc
 */
@Service
public class QuestionServImpl implements QuestionServ {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionDetailMapper questionDetailMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private RecordDetailMapper recordDetailMapper;
    @Autowired
    private ConfigMapper configMapper;

    @Override
    public QuestionVO getQuestionById(Integer id) {
        QuestionVO vo = new QuestionVO();
        Question question = questionMapper.selectByPrimaryKey(id);
        vo.setId(question.getId());
        vo.setType(question.getType());
        vo.setScore(question.getScore());
        vo.setSubject(question.getSubject());
        QuestionDetail detail = new QuestionDetail();
        detail.setQuestionId(id);
        List<QuestionDetail> detailList = questionDetailMapper.select(detail);
        vo.setDetailList(detailList);
        return vo;
    }

    @Override
    public Boolean answer(QuestionDTO questionDTO) {
        Integer questionId = questionDTO.getQuestionId();
        Integer userId = questionDTO.getUserId();
        String userAnswer = questionDTO.getAnswer();

        Date now = new Date();
        Record record = new Record();
        record.setUserId(userId);
        record = recordMapper.selectOne(record);
        // 答题开始 记录考试开始时间
        if (1 == questionId && record.getStartTime() == null) {
            Config config = configMapper.selectAll().get(0);
            record.setStartTime(config.getStartTime());
            recordMapper.updateByPrimaryKeySelective(record);
        }

        Question question = questionMapper.selectByPrimaryKey(questionId);
        User user = userMapper.selectByPrimaryKey(userId);
        boolean isCorrect = false;
        RecordDetail query = new RecordDetail();
        query.setUserId(userId);
        query.setQuestionId(questionId);
        query = recordDetailMapper.selectOne(query);
        if (query != null) {
            recordDetailMapper.delete(query);
        }

        RecordDetail recordDetail = new RecordDetail();
        recordDetail.setRecordId(record.getId());
        recordDetail.setQuestionId(question.getId());
        recordDetail.setQuestion(question.getSubject());
        recordDetail.setUseTime(questionDTO.getUseTime());
        String correct = question.getCorrect();
        recordDetail.setCorrectAnswer(correct);
        recordDetail.setUserId(userId);
        recordDetail.setUserName(user.getUserName());
        recordDetail.setScore(question.getScore());

        if (StringUtils.isEmpty(userAnswer)) {
            userAnswer = "超时";
            recordDetail.setIsCorrect(false);
        } else {
            isCorrect = correct.equals(userAnswer);
            recordDetail.setIsCorrect(isCorrect);
        }
        recordDetail.setUserAnswer(userAnswer);
        recordDetail.setCtime(now);
        recordDetailMapper.insertSelective(recordDetail);

        // 答题结束 计算答题使用时间
        if (questionDTO.getIsFinish() != null && questionDTO.getIsFinish()) {
            if (record.getEndTime() == null) {
                record.setEndTime(now);
                record.setUseTime(now.getTime() - record.getStartTime().getTime());
                recordMapper.updateByPrimaryKeySelective(record);
            }
        }

       /* if (isCorrect) {
            record.setTotalScore(record.getTotalScore() + question.getScore());
            recordMapper.updateByPrimaryKeySelective(record);
        }*/

        return isCorrect;
    }

    @Override
    public List<AchievementVO> getAchievement() {

        List<AchievementVO> resultList = new ArrayList<>();
        List<Record> records = recordMapper.getRecordList();
     /*   List<Record> collect = records.stream().sorted(Comparator.comparing(Record::getTotalScore).reversed().thenComparing(Record::getUseTime)).collect(Collectors.toList());
        List<Record> collect = records.stream().sorted(Comparator.comparing(Record::getUseTime)).collect(Collectors.toList());
        List<Record> headList = records.subList(0, 20);
        int size = records.size();
        List<Record> tailList = records.subList(size - 10, size);*/
        List<Record> recordList = new ArrayList<>(records);
        //recordList.addAll(tailList);

        for (Record record : recordList) {
            AchievementVO vo = new AchievementVO();
            vo.setUserId(record.getUserId());
            vo.setUserName(record.getUserName());
            vo.setTotalScore(record.getTotalScore());
            vo.setCrossSector(record.getIsCrossSector());
            // 处理使用时间
            long time = record.getUseTime();
            if (time == 99999999) {
                vo.setUseTime("未完成");
            } else {
                long hour = time / (60 * 60 * 1000);
                long minute = (time - hour * 60 * 60 * 1000) / (60 * 1000);
                long second = (time - hour * 60 * 60 * 1000 - minute * 60 * 1000) / 1000;
                vo.setUseTime(hour + "小时" + minute + "分" + second + "秒");
            }
            resultList.add(vo);
        }

        return resultList;
    }

    @Override
    public void add(QuestionDTO dto) {
        Question insert = new Question();
        insert.setSubject(dto.getSubject());
        insert.setType(dto.getType());
        insert.setCorrect(dto.getCorrect());
        insert.setMajorType(dto.getMajorType());
        questionMapper.insertSelective(insert);
        Question question1 = questionMapper.selectOne(insert);

        QuestionDetail detail1  = new QuestionDetail();
        detail1.setQuestionId(question1.getId());
        detail1.setLogo("A");
        detail1.setContent(dto.getA());
        questionDetailMapper.insertSelective(detail1);

        QuestionDetail detail2  = new QuestionDetail();
        detail2.setQuestionId(question1.getId());
        detail2.setLogo("B");
        detail2.setContent(dto.getB());
        questionDetailMapper.insertSelective(detail2);

        QuestionDetail detail3  = new QuestionDetail();
        detail3.setQuestionId(question1.getId());
        detail3.setLogo("C");
        detail3.setContent(dto.getC());
        questionDetailMapper.insertSelective(detail3);

        QuestionDetail detai4  = new QuestionDetail();
        detai4.setQuestionId(question1.getId());
        detai4.setLogo("D");
        detai4.setContent(dto.getD());
        questionDetailMapper.insertSelective(detai4);

    }
}
