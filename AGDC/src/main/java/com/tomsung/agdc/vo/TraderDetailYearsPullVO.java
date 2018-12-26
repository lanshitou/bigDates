package com.tomsung.agdc.vo;

import java.util.List;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/25 15:04
 */
public class TraderDetailYearsPullVO {
    private Integer cropId;
    private String cropName;
    private List<Integer> years;

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }
}
