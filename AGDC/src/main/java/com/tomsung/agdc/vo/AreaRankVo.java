package com.tomsung.agdc.vo;

/**
 * 区域排名
 * Created by Lvpin on 2018/9/12.
 */
public class AreaRankVo {
    private Integer rank;
    private String city;
    private Integer count;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
