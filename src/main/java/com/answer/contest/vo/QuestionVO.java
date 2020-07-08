package com.answer.contest.vo;

import com.answer.contest.entity.QuestionDetail;
import lombok.Data;

import java.util.List;

/**
 * @author dzy
 * @date 2020/6/28
 * @desc
 */
@Data
public class QuestionVO {

    private Integer id;

    /**
     * 类型(1-单选,2-多选,3-判断)
     */
    private Integer type;

    /**
     * 题目
     */
    private String subject;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 正确答案
     */
    private String correct;

    private List<QuestionDetail> detailList;
}
