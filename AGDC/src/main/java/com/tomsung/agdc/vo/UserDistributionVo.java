package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/10/9.
 * 用户分布（地图）
 */
public class UserDistributionVo {
    private String address;
    private Integer vip = 0;
    private Integer notVip = 0;
    private String addX;
    private String addY;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getAddX() {
        return addX;
    }

    public void setAddX(String addX) {
        this.addX = addX;
    }

    public String getAddY() {
        return addY;
    }

    public void setAddY(String addY) {
        this.addY = addY;
    }
}
