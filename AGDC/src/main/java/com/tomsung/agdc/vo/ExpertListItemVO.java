package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zhangqi
 * @Date: 2018/10/8 10:01
 * @Description:
 */
public class ExpertListItemVO {

    private Integer userId;

    private String name;

    private Integer age;

    private Integer sex;

    private String tel;

    private String type;

    private String cropName;

    private BigDecimal scoreAvg;

    private Date verifiedTime;

    private String address;

    private Integer postCount;

    private Integer replyCount;

    private String intro;

    private Integer oneYearPost;

    private Integer oneYearReply;

    private String liveness;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public BigDecimal getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(BigDecimal scoreAvg) {
        this.scoreAvg = scoreAvg;
    }

    public Date getVerifiedTime() {
        return verifiedTime;
    }

    public void setVerifiedTime(Date verifiedTime) {
        this.verifiedTime = verifiedTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getOneYearPost() {
        return oneYearPost;
    }

    public void setOneYearPost(Integer oneYearPost) {
        this.oneYearPost = oneYearPost;
    }

    public Integer getOneYearReply() {
        return oneYearReply;
    }

    public void setOneYearReply(Integer oneYearReply) {
        this.oneYearReply = oneYearReply;
    }

    public String getLiveness() {
        return liveness;
    }

    public void setLiveness(String liveness) {
        this.liveness = liveness;
    }
}
