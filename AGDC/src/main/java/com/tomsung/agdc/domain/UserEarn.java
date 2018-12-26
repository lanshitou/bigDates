package com.tomsung.agdc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEarn {
    private Integer id;

    private Integer userId;

    private Integer cropId;

    private String cropName;

    private BigDecimal planUnitPrice;

    private Integer salesVolume;

    private Integer annual;

    private BigDecimal unitPrice;

    private BigDecimal planCost;

    private BigDecimal cost;

    private Date createTime;

    private Date updateTime;

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
        this.cropName = cropName == null ? null : cropName.trim();
    }

    public BigDecimal getPlanUnitPrice() {
        return planUnitPrice;
    }

    public void setPlanUnitPrice(BigDecimal planUnitPrice) {
        this.planUnitPrice = planUnitPrice;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getPlanCost() {
        return planCost;
    }

    public void setPlanCost(BigDecimal planCost) {
        this.planCost = planCost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
        UserEarn other = (UserEarn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCropId() == null ? other.getCropId() == null : this.getCropId().equals(other.getCropId()))
            && (this.getCropName() == null ? other.getCropName() == null : this.getCropName().equals(other.getCropName()))
            && (this.getPlanUnitPrice() == null ? other.getPlanUnitPrice() == null : this.getPlanUnitPrice().equals(other.getPlanUnitPrice()))
            && (this.getSalesVolume() == null ? other.getSalesVolume() == null : this.getSalesVolume().equals(other.getSalesVolume()))
            && (this.getAnnual() == null ? other.getAnnual() == null : this.getAnnual().equals(other.getAnnual()))
            && (this.getUnitPrice() == null ? other.getUnitPrice() == null : this.getUnitPrice().equals(other.getUnitPrice()))
            && (this.getPlanCost() == null ? other.getPlanCost() == null : this.getPlanCost().equals(other.getPlanCost()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCropId() == null) ? 0 : getCropId().hashCode());
        result = prime * result + ((getCropName() == null) ? 0 : getCropName().hashCode());
        result = prime * result + ((getPlanUnitPrice() == null) ? 0 : getPlanUnitPrice().hashCode());
        result = prime * result + ((getSalesVolume() == null) ? 0 : getSalesVolume().hashCode());
        result = prime * result + ((getAnnual() == null) ? 0 : getAnnual().hashCode());
        result = prime * result + ((getUnitPrice() == null) ? 0 : getUnitPrice().hashCode());
        result = prime * result + ((getPlanCost() == null) ? 0 : getPlanCost().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}