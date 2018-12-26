package com.tomsung.agdc.dto;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/25 18:34
 */
public class TraderIncomeCompareDTO {
    private Integer userId;
    private Integer startYear;
    private Integer endYear;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
}
