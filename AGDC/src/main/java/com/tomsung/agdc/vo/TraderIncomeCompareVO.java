package com.tomsung.agdc.vo;

import java.math.BigDecimal;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/25 18:46
 */
public class TraderIncomeCompareVO {
    private Integer year;
    private BigDecimal money;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
