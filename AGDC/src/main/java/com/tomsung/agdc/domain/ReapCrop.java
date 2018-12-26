package com.tomsung.agdc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ReapCrop {
    private Integer id;

    private Integer plantId;

    private String cropName;

    private Integer userId;

    private BigDecimal grainWeight;

    private BigDecimal earWeight;

    private BigDecimal sugarDegree;

    private BigDecimal fruitionPercent;

    private Byte isQualified;

    private Byte overallQuality;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName == null ? null : cropName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getGrainWeight() {
        return grainWeight;
    }

    public void setGrainWeight(BigDecimal grainWeight) {
        this.grainWeight = grainWeight;
    }

    public BigDecimal getEarWeight() {
        return earWeight;
    }

    public void setEarWeight(BigDecimal earWeight) {
        this.earWeight = earWeight;
    }

    public BigDecimal getSugarDegree() {
        return sugarDegree;
    }

    public void setSugarDegree(BigDecimal sugarDegree) {
        this.sugarDegree = sugarDegree;
    }

    public BigDecimal getFruitionPercent() {
        return fruitionPercent;
    }

    public void setFruitionPercent(BigDecimal fruitionPercent) {
        this.fruitionPercent = fruitionPercent;
    }

    public Byte getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Byte isQualified) {
        this.isQualified = isQualified;
    }

    public Byte getOverallQuality() {
        return overallQuality;
    }

    public void setOverallQuality(Byte overallQuality) {
        this.overallQuality = overallQuality;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        ReapCrop other = (ReapCrop) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlantId() == null ? other.getPlantId() == null : this.getPlantId().equals(other.getPlantId()))
            && (this.getCropName() == null ? other.getCropName() == null : this.getCropName().equals(other.getCropName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGrainWeight() == null ? other.getGrainWeight() == null : this.getGrainWeight().equals(other.getGrainWeight()))
            && (this.getEarWeight() == null ? other.getEarWeight() == null : this.getEarWeight().equals(other.getEarWeight()))
            && (this.getSugarDegree() == null ? other.getSugarDegree() == null : this.getSugarDegree().equals(other.getSugarDegree()))
            && (this.getFruitionPercent() == null ? other.getFruitionPercent() == null : this.getFruitionPercent().equals(other.getFruitionPercent()))
            && (this.getIsQualified() == null ? other.getIsQualified() == null : this.getIsQualified().equals(other.getIsQualified()))
            && (this.getOverallQuality() == null ? other.getOverallQuality() == null : this.getOverallQuality().equals(other.getOverallQuality()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlantId() == null) ? 0 : getPlantId().hashCode());
        result = prime * result + ((getCropName() == null) ? 0 : getCropName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGrainWeight() == null) ? 0 : getGrainWeight().hashCode());
        result = prime * result + ((getEarWeight() == null) ? 0 : getEarWeight().hashCode());
        result = prime * result + ((getSugarDegree() == null) ? 0 : getSugarDegree().hashCode());
        result = prime * result + ((getFruitionPercent() == null) ? 0 : getFruitionPercent().hashCode());
        result = prime * result + ((getIsQualified() == null) ? 0 : getIsQualified().hashCode());
        result = prime * result + ((getOverallQuality() == null) ? 0 : getOverallQuality().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}