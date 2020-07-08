package com.answer.contest.serv.impl;

import com.answer.contest.dto.UserDTO;
import com.answer.contest.entity.*;
import com.answer.contest.mapper.ConfigMapper;
import com.answer.contest.mapper.QuestionMapper;
import com.answer.contest.mapper.RecordMapper;
import com.answer.contest.mapper.UserMapper;
import com.answer.contest.serv.UserServ;
import com.answer.contest.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServImpl implements UserServ {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ConfigMapper configMapper;

    @Override
    public Result login(UserDTO userDTO) {
        Config config = configMapper.selectAll().get(0);
        Date startTime = config.getStartTime();
        if (new Date().before(startTime)) {
            return new Result<>().genFailResult(ResultCode.SYSTEM_ERROR, "答题未开始");
        }
        Date endTime = config.getEndTime();
        if (new Date().after(endTime)) {
            return new Result<>().genFailResult(ResultCode.SYSTEM_ERROR, "答题已结束");
        }

        User query = new User();
        query.setAccount(userDTO.getAccount());
        query.setPassword(userDTO.getPassword());
        User user = userMapper.selectOne(query);
        if (user == null) {
           return new Result<>().genFailResult(ResultCode.PARAMS_ERROR, "账号或密码错误");
        }

        UserVO userVO = new UserVO();
        userVO.setUserId(user.getId());
        userVO.setUserName(user.getUserName());
        userVO.setQuestionNum(config.getQuestionNum());
        userVO.setStartTime(config.getStartTime().getTime() - new Date().getTime());
        userVO.setMajorType(user.getMajorType());
        Question question = new Question();
        question.setMajorType(user.getMajorType());
        List<Question> questionList = questionMapper.select(question);
        if (!CollectionUtils.isEmpty(questionList)) {
            List<Integer> majorQuestionIdList = questionList.stream().map(Question::getId).collect(Collectors.toList());
            userVO.setMajorQuestionIdList(majorQuestionIdList);
        } else {
            userVO.setMajorQuestionIdList(new ArrayList<>());
        }
        return new Result<>().genSuccessResult(userVO);
    }

    @Override
    public void addUser() {

        for (int j = 1; j < 84; j++) {
            String value = StringUtils.leftPad(String.valueOf(j), 3, "0");
            User user = new User();
            user.setAccount("runa" + value);
            user.setPassword("123456");
            userMapper.insertSelective(user);
        }

    }

    @Override
    public void addRecord() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            Record record = new Record();
            record.setUserId(user.getId());
            record.setUserName(user.getUserName());
            recordMapper.insertSelective(record);
        }
    }

}
