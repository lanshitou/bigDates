package com.tomsung.agdc.vo;

import java.util.Objects;

/**
 * Created by Lvpin on 2018/9/21.
 */
public class MonthVo {
    private Integer month;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthVo monthVo = (MonthVo) o;
        return Objects.equals(month, monthVo.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month);
    }
}
