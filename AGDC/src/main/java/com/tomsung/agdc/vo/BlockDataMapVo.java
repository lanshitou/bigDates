package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/10/11.
 */
public class BlockDataMapVo {
    private Integer isAuto;
    private String address;
    private Double area = new Double(0);
    private String crop = "";
    private String user;
    private Double addX;
    private Double addY;

    public Integer getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Integer isAuto) {
        this.isAuto = isAuto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getAddX() {
        return addX;
    }

    public void setAddX(Double addX) {
        this.addX = addX;
    }

    public Double getAddY() {
        return addY;
    }

    public void setAddY(Double addY) {
        this.addY = addY;
    }
}
