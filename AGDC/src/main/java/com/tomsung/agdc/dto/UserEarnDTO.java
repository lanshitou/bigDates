package com.tomsung.agdc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author: zhangqi
 * @Date: 2018/9/15 15:08
 * @Description:
 */
public class UserEarnDTO {

    private Integer beginAnnual;

    private Integer endAnnual;

    private Integer userId;

    private Integer annual;

    public Integer getBeginAnnual() {
        return beginAnnual;
    }

    public void setBeginAnnual(Integer beginAnnual) {
        this.beginAnnual = beginAnnual;
    }

    public Integer getEndAnnual() {
        return endAnnual;
    }

    public void setEndAnnual(Integer endAnnual) {
        this.endAnnual = endAnnual;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }
}
