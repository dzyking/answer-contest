package com.answer.contest.dto;

import lombok.Data;

/**
 * @author dzy
 * @date 2020/6/28
 * @desc
 */
@Data
public class QuestionDTO {

    private Integer userId;

    private Integer questionId;

    private String answer;

    private Integer useTime;

    private Boolean isFinish;

    private String subject;
    private Integer majorType;
    private Integer type;
    private String correct;
    private String A;
    private String B;
    private String C;
    private String D;
}
