package com.tomsung.agdc.domain;

import java.util.Date;

/**
 * Created by Lvpin on 2018/8/13.
 */
public class Planting {
    private Integer pantingId;
    private Integer userId;
    private Integer cropId;
    private String cropName;
    private Double  cropArea;
    private String principal;
    private String phone;
    private Integer annual;
    private String batch;
    private Integer isLock;
    private Integer plantOutput;
    private Integer scene;
    private Date growTime;
    private Date reapTime;

    public Integer getPantingId() {
        return pantingId;
    }

    public void setPantingId(Integer pantingId) {
        this.pantingId = pantingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Double getCropArea() {
        return cropArea;
    }

    public void setCropArea(Double cropArea) {
        this.cropArea = cropArea;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public Integer getPlantOutput() {
        return plantOutput;
    }

    public void setPlantOutput(Integer plantOutput) {
        this.plantOutput = plantOutput;
    }

    public Integer getScene() {
        return scene;
    }

    public void setScene(Integer scene) {
        this.scene = scene;
    }

    public Date getGrowTime() {
        return growTime;
    }

    public void setGrowTime(Date growTime) {
        this.growTime = growTime;
    }

    public Date getReapTime() {
        return reapTime;
    }

    public void setReapTime(Date reapTime) {
        this.reapTime = reapTime;
    }
}
