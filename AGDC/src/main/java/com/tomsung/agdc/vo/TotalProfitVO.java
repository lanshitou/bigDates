package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

/**
 * @author: zhangqi
 * @Date: 2018/9/19 14:15
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TotalProfitVO {

    private Integer annual;

    private BigDecimal profit;

    private BigDecimal planProfit;

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getPlanProfit() {
        return planProfit;
    }

    public void setPlanProfit(BigDecimal planProfit) {
        this.planProfit = planProfit;
    }
}
