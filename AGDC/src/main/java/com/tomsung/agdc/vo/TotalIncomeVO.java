package com.tomsung.agdc.vo;

import java.math.BigDecimal;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 17:29
 * @Description:
 */
public class TotalIncomeVO {

    private Integer annual;

    private BigDecimal totalIncome;

    private BigDecimal planIncome;

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getPlanIncome() {
        return planIncome;
    }

    public void setPlanIncome(BigDecimal planIncome) {
        this.planIncome = planIncome;
    }
}
