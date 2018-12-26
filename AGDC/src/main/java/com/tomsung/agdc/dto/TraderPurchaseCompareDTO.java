package com.tomsung.agdc.dto;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/25 14:38
 */
public class TraderPurchaseCompareDTO {
    private Integer userId;
    private Integer cropId;
    private Integer startYear;
    private Integer endYear;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
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
