package com.answer.contest.entity;

import javax.persistence.*;

@Table(name = "question_detail")
public class QuestionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id")
    private Integer questionId;

    /**
     * 选项标识
     */
    private String logo;

    /**
     * 内容
     */
    private String content;

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
     * @return question_id
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取选项标识
     *
     * @return logo - 选项标识
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置选项标识
     *
     * @param logo 选项标识
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", questionId=").append(questionId);
        sb.append(", logo=").append(logo);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}