package com.answer.contest.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "record_detail")
public class RecordDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    /**
     * 记录ID
     */
    @Column(name = "record_id")
    private Integer recordId;

    /**
     * 题目ID
     */
    @Column(name = "question_id")
    private Integer questionId;

    /**
     * 题目
     */
    private String question;

    /**
     * 正确答案
     */
    @Column(name = "correct_answer")
    private String correctAnswer;

    /**
     * 用户答案
     */
    @Column(name = "user_answer")
    private String userAnswer;

    /**
     * 用时(秒)
     */
    @Column(name = "use_time")
    private Integer useTime;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 是否正确
     */
    @Column(name = "is_correct")
    private Boolean isCorrect;

    /**
     * 提交时间
     */
    private Date ctime;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * 获取题目ID
     *
     * @return question_id - 题目ID
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 设置题目ID
     *
     * @param questionId 题目ID
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取题目
     *
     * @return question - 题目
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置题目
     *
     * @param question 题目
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取正确答案
     *
     * @return correct_answer - 正确答案
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * 设置正确答案
     *
     * @param correctAnswer 正确答案
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * 获取用户答案
     *
     * @return user_answer - 用户答案
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     * 设置用户答案
     *
     * @param userAnswer 用户答案
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * 获取用时(秒)
     *
     * @return use_time - 用时(秒)
     */
    public Integer getUseTime() {
        return useTime;
    }

    /**
     * 设置用时(秒)
     *
     * @param useTime 用时(秒)
     */
    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
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
     * 获取是否正确
     *
     * @return is_correct - 是否正确
     */
    public Boolean getIsCorrect() {
        return isCorrect;
    }

    /**
     * 设置是否正确
     *
     * @param isCorrect 是否正确
     */
    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    /**
     * 获取提交时间
     *
     * @return ctime - 提交时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置提交时间
     *
     * @param ctime 提交时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", questionId=").append(questionId);
        sb.append(", question=").append(question);
        sb.append(", correctAnswer=").append(correctAnswer);
        sb.append(", userAnswer=").append(userAnswer);
        sb.append(", useTime=").append(useTime);
        sb.append(", score=").append(score);
        sb.append(", isCorrect=").append(isCorrect);
        sb.append(", ctime=").append(ctime);
        sb.append("]");
        return sb.toString();
    }
}