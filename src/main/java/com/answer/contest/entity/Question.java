package com.answer.contest.entity;

import javax.persistence.*;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型(1-单选,2-多选,3-判断)
     */
    private Integer type;

    /**
     * 专业类型
     */
    @Column(name = "major_type")
    private Integer majorType;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 正确答案
     */
    private String correct;

    /**
     * 题目
     */
    private String subject;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类型(1-单选,2-多选,3-判断)
     *
     * @return type - 类型(1-单选,2-多选,3-判断)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型(1-单选,2-多选,3-判断)
     *
     * @param type 类型(1-单选,2-多选,3-判断)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取专业类型
     *
     * @return major_type - 专业类型
     */
    public Integer getMajorType() {
        return majorType;
    }

    /**
     * 设置专业类型
     *
     * @param majorType 专业类型
     */
    public void setMajorType(Integer majorType) {
        this.majorType = majorType;
    }

    /**
     * 获取分数
     *
     * @return score - 分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置分数
     *
     * @param score 分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取正确答案
     *
     * @return correct - 正确答案
     */
    public String getCorrect() {
        return correct;
    }

    /**
     * 设置正确答案
     *
     * @param correct 正确答案
     */
    public void setCorrect(String correct) {
        this.correct = correct;
    }

    /**
     * 获取题目
     *
     * @return subject - 题目
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置题目
     *
     * @param subject 题目
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", majorType=").append(majorType);
        sb.append(", score=").append(score);
        sb.append(", correct=").append(correct);
        sb.append(", subject=").append(subject);
        sb.append("]");
        return sb.toString();
    }
}