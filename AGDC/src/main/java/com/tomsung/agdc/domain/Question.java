package com.tomsung.agdc.domain;

import java.util.Date;

public class Question {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.CROP_ID
     *
     * @mbg.generated
     */
    private Integer cropId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.POST_UID
     *
     * @mbg.generated
     */
    private Integer postUid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.CROP_NAME
     *
     * @mbg.generated
     */
    private String cropName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.CONTENT
     *
     * @mbg.generated
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.REPLY_COUNT
     *
     * @mbg.generated
     */
    private String replyCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.ADOPT_REPLY_ID
     *
     * @mbg.generated
     */
    private String adoptReplyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.POST_TIME
     *
     * @mbg.generated
     */
    private Date postTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QUESTION.IS_DEL
     *
     * @mbg.generated
     */
    private Integer isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.ID
     *
     * @return the value of QUESTION.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.ID
     *
     * @param id the value for QUESTION.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.CROP_ID
     *
     * @return the value of QUESTION.CROP_ID
     *
     * @mbg.generated
     */
    public Integer getCropId() {
        return cropId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.CROP_ID
     *
     * @param cropId the value for QUESTION.CROP_ID
     *
     * @mbg.generated
     */
    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.POST_UID
     *
     * @return the value of QUESTION.POST_UID
     *
     * @mbg.generated
     */
    public Integer getPostUid() {
        return postUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.POST_UID
     *
     * @param postUid the value for QUESTION.POST_UID
     *
     * @mbg.generated
     */
    public void setPostUid(Integer postUid) {
        this.postUid = postUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.CROP_NAME
     *
     * @return the value of QUESTION.CROP_NAME
     *
     * @mbg.generated
     */
    public String getCropName() {
        return cropName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.CROP_NAME
     *
     * @param cropName the value for QUESTION.CROP_NAME
     *
     * @mbg.generated
     */
    public void setCropName(String cropName) {
        this.cropName = cropName == null ? null : cropName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.CONTENT
     *
     * @return the value of QUESTION.CONTENT
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.CONTENT
     *
     * @param content the value for QUESTION.CONTENT
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.REPLY_COUNT
     *
     * @return the value of QUESTION.REPLY_COUNT
     *
     * @mbg.generated
     */
    public String getReplyCount() {
        return replyCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.REPLY_COUNT
     *
     * @param replyCount the value for QUESTION.REPLY_COUNT
     *
     * @mbg.generated
     */
    public void setReplyCount(String replyCount) {
        this.replyCount = replyCount == null ? null : replyCount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.ADOPT_REPLY_ID
     *
     * @return the value of QUESTION.ADOPT_REPLY_ID
     *
     * @mbg.generated
     */
    public String getAdoptReplyId() {
        return adoptReplyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.ADOPT_REPLY_ID
     *
     * @param adoptReplyId the value for QUESTION.ADOPT_REPLY_ID
     *
     * @mbg.generated
     */
    public void setAdoptReplyId(String adoptReplyId) {
        this.adoptReplyId = adoptReplyId == null ? null : adoptReplyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.POST_TIME
     *
     * @return the value of QUESTION.POST_TIME
     *
     * @mbg.generated
     */
    public Date getPostTime() {
        return postTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.POST_TIME
     *
     * @param postTime the value for QUESTION.POST_TIME
     *
     * @mbg.generated
     */
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.IS_DEL
     *
     * @return the value of QUESTION.IS_DEL
     *
     * @mbg.generated
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.IS_DEL
     *
     * @param isDel the value for QUESTION.IS_DEL
     *
     * @mbg.generated
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCropId() == null ? other.getCropId() == null : this.getCropId().equals(other.getCropId()))
            && (this.getPostUid() == null ? other.getPostUid() == null : this.getPostUid().equals(other.getPostUid()))
            && (this.getCropName() == null ? other.getCropName() == null : this.getCropName().equals(other.getCropName()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getReplyCount() == null ? other.getReplyCount() == null : this.getReplyCount().equals(other.getReplyCount()))
            && (this.getAdoptReplyId() == null ? other.getAdoptReplyId() == null : this.getAdoptReplyId().equals(other.getAdoptReplyId()))
            && (this.getPostTime() == null ? other.getPostTime() == null : this.getPostTime().equals(other.getPostTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCropId() == null) ? 0 : getCropId().hashCode());
        result = prime * result + ((getPostUid() == null) ? 0 : getPostUid().hashCode());
        result = prime * result + ((getCropName() == null) ? 0 : getCropName().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getReplyCount() == null) ? 0 : getReplyCount().hashCode());
        result = prime * result + ((getAdoptReplyId() == null) ? 0 : getAdoptReplyId().hashCode());
        result = prime * result + ((getPostTime() == null) ? 0 : getPostTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }
    private Integer solvedCount;
    private Integer questionCount;
    private String cityName;

    public Integer getSolvedCount() {
        return solvedCount;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setSolvedCount(Integer solvedCount) {
        this.solvedCount = solvedCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}