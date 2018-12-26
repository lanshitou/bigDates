package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/9/14.
 */
public class ActiveCountVo {

    private String time;
    private Integer userCount = new Integer(0);
    private Integer expertCount = new Integer(0);

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getExpertCount() {
        return expertCount;
    }

    public void setExpertCount(Integer expertCount) {
        this.expertCount = expertCount;
    }
}
