package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/10/9.
 */
public class AreaUserRankVo {
    private Integer vip = 0;
    private Integer notVip = 0;
    private String address;

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getNotVip() {
        return notVip;
    }

    public void setNotVip(Integer notVip) {
        this.notVip = notVip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
