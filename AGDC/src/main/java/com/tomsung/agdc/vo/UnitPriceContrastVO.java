package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import com.tomsung.agdc.domain.UserEarn;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 10:34
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnitPriceContrastVO {

    private Integer cropId;

    private String cropName;

    private List<Integer> annualList;

    private List<BigDecimal> unitPriceList;

    private List<BigDecimal> planUnitPriceList;

    public UnitPriceContrastVO(Integer cropId, String cropName){
        this.cropId = cropId;
        this.cropName = cropName;
        annualList = Lists.newArrayList();
        unitPriceList = Lists.newArrayList();
        planUnitPriceList = Lists.newArrayList();
    }

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

    public List<Integer> getAnnualList() {
        return annualList;
    }

    public void setAnnualList(List<Integer> annualList) {
        this.annualList = annualList;
    }

    public List<BigDecimal> getUnitPriceList() {
        return unitPriceList;
    }

    public void setUnitPriceList(List<BigDecimal> unitPriceList) {
        this.unitPriceList = unitPriceList;
    }

    public List<BigDecimal> getPlanUnitPriceList() {
        return planUnitPriceList;
    }

    public void setPlanUnitPriceList(List<BigDecimal> planUnitPriceList) {
        this.planUnitPriceList = planUnitPriceList;
    }
}
