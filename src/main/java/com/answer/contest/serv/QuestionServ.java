package com.answer.contest.serv;

import com.answer.contest.vo.AchievementVO;
import com.answer.contest.dto.QuestionDTO;
import com.answer.contest.vo.QuestionVO;

import java.util.List;

public interface QuestionServ {

    QuestionVO getQuestionById (Integer id);

    Boolean answer (QuestionDTO questionDTO);

    List<AchievementVO> getAchievement();

    void add (QuestionDTO question);

}
