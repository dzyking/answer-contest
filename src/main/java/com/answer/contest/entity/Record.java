package com.answer.contest.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 使用时间
     */
    @Column(name = "use_time")
    private Long useTime;

    /**
     * 总分
     */
    @Column(name = "total_score")
    private Integer totalScore;

    /**
     * 是否跨部门
     */
    @Column(name = "is_cross_sector")
    private Boolean isCrossSector;

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

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取使用时间
     *
     * @return use_time - 使用时间
     */
    public Long getUseTime() {
        return useTime;
    }

    /**
     * 设置使用时间
     *
     * @param useTime 使用时间
     */
    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    /**
     * 获取总分
     *
     * @return total_score - 总分
     */
    public Integer getTotalScore() {
        return totalScore;
    }

    /**
     * 设置总分
     *
     * @param totalScore 总分
     */
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * 获取是否跨部门
     *
     * @return is_cross_sector - 是否跨部门
     */
    public Boolean getIsCrossSector() {
        return isCrossSector;
    }

    /**
     * 设置是否跨部门
     *
     * @param isCrossSector 是否跨部门
     */
    public void setIsCrossSector(Boolean isCrossSector) {
        this.isCrossSector = isCrossSector;
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
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", useTime=").append(useTime);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", isCrossSector=").append(isCrossSector);
        sb.append("]");
        return sb.toString();
    }
}