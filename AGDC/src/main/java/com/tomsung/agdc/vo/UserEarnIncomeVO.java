package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tomsung.agdc.domain.UserEarn;

import java.math.BigDecimal;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 16:41
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEarnIncomeVO {

    private Integer cropId;

    private String cropName;

    private BigDecimal income;

    private BigDecimal planIncome;

    public UserEarnIncomeVO(UserEarn userEarn){

        cropId = userEarn.getCropId();
        cropName = userEarn.getCropName();
        income = userEarn.getUnitPrice().multiply(new BigDecimal(userEarn.getSalesVolume()));
        planIncome = userEarn.getPlanUnitPrice().multiply(new BigDecimal(userEarn.getSalesVolume()));

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

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getPlanIncome() {
        return planIncome;
    }

    public void setPlanIncome(BigDecimal planIncome) {
        this.planIncome = planIncome;
    }
}
