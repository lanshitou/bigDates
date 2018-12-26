package com.tomsung.agdc.vo;

import java.util.List;

/**
 * Created by Lvpin on 2018/10/8.
 */
public class IncomeComparisonVo {
    private String name;
    private List<AreaAndAvgVo> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
