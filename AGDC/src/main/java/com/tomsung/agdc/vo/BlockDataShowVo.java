package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/10/10.
 */
public class BlockDataShowVo {
    private String name;
    private Integer count = 0;
    private Integer monthCount = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }
}
