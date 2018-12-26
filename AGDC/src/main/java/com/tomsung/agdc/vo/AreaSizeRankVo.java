package com.tomsung.agdc.vo;


/**
 * Created by Lvpin on 2018/9/28.
 */
public class AreaSizeRankVo {
    private String cityName;
    private Double summ;
    private Integer cropCount = 0;
    private Integer areaCode;

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }


    public Integer getCropCount() {
        return cropCount;
    }

    public void setCropCount(Integer cropCount) {
        this.cropCount = cropCount;
    }
}
