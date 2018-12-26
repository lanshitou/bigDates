package com.tomsung.agdc.domain;

import java.util.Date;

public class PlantingLog {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer plantingId;

    private String plantingType;

    private String plantingDetail;

    private Integer plantingTime;

    private Boolean isLock;

    private Date addTime;

    private Date updateTime;

    private String plantingImages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getPlantingId() {
        return plantingId;
    }

    public void setPlantingId(Integer plantingId) {
        this.plantingId = plantingId;
    }

    public String getPlantingType() {
        return plantingType;
    }

    public void setPlantingType(String plantingType) {
        this.plantingType = plantingType == null ? null : plantingType.trim();
    }

    public String getPlantingDetail() {
        return plantingDetail;
    }

    public void setPlantingDetail(String plantingDetail) {
        this.plantingDetail = plantingDetail == null ? null : plantingDetail.trim();
    }

    public Integer getPlantingTime() {
        return plantingTime;
    }

    public void setPlantingTime(Integer plantingTime) {
        this.plantingTime = plantingTime;
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPlantingImages() {
        return plantingImages;
    }

    public void setPlantingImages(String plantingImages) {
        this.plantingImages = plantingImages == null ? null : plantingImages.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PlantingLog other = (PlantingLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPlantingId() == null ? other.getPlantingId() == null : this.getPlantingId().equals(other.getPlantingId()))
            && (this.getPlantingType() == null ? other.getPlantingType() == null : this.getPlantingType().equals(other.getPlantingType()))
            && (this.getPlantingDetail() == null ? other.getPlantingDetail() == null : this.getPlantingDetail().equals(other.getPlantingDetail()))
            && (this.getPlantingTime() == null ? other.getPlantingTime() == null : this.getPlantingTime().equals(other.getPlantingTime()))
            && (this.getIsLock() == null ? other.getIsLock() == null : this.getIsLock().equals(other.getIsLock()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPlantingImages() == null ? other.getPlantingImages() == null : this.getPlantingImages().equals(other.getPlantingImages()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPlantingId() == null) ? 0 : getPlantingId().hashCode());
        result = prime * result + ((getPlantingType() == null) ? 0 : getPlantingType().hashCode());
        result = prime * result + ((getPlantingDetail() == null) ? 0 : getPlantingDetail().hashCode());
        result = prime * result + ((getPlantingTime() == null) ? 0 : getPlantingTime().hashCode());
        result = prime * result + ((getIsLock() == null) ? 0 : getIsLock().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPlantingImages() == null) ? 0 : getPlantingImages().hashCode());
        return result;
    }
}