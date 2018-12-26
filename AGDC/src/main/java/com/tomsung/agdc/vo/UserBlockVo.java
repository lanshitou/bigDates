package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/9/7.
 */
public class UserBlockVo {
    private Integer blockId;
    private Double blockArea;
    private String cropName;
    private String address;
    private String userName;
    private String tel;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Double getBlockArea() {
        return blockArea;
    }

    public void setBlockArea(Double blockArea) {
        this.blockArea = blockArea;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
