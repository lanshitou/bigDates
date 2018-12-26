package com.tomsung.agdc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoilStandardItem extends SoilStandardItemKey {
    private BigDecimal value;

    private BigDecimal highValue;

    private BigDecimal middleValue;

    private BigDecimal lowValue;

    private Date createTime;

    private Date updateTime;

    private String itemName;

    private Byte itemUnit;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getHighValue() {
        return highValue;
    }

    public void setHighValue(BigDecimal highValue) {
        this.highValue = highValue;
    }

    public BigDecimal getMiddleValue() {
        return middleValue;
    }

    public void setMiddleValue(BigDecimal middleValue) {
        this.middleValue = middleValue;
    }

    public BigDecimal getLowValue() {
        return lowValue;
    }

    public void setLowValue(BigDecimal lowValue) {
        this.lowValue = lowValue;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Byte getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(Byte itemUnit) {
        this.itemUnit = itemUnit;
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
        SoilStandardItem other = (SoilStandardItem) that;
        return (this.getSoilStandardId() == null ? other.getSoilStandardId() == null : this.getSoilStandardId().equals(other.getSoilStandardId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getHighValue() == null ? other.getHighValue() == null : this.getHighValue().equals(other.getHighValue()))
            && (this.getMiddleValue() == null ? other.getMiddleValue() == null : this.getMiddleValue().equals(other.getMiddleValue()))
            && (this.getLowValue() == null ? other.getLowValue() == null : this.getLowValue().equals(other.getLowValue()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSoilStandardId() == null) ? 0 : getSoilStandardId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getHighValue() == null) ? 0 : getHighValue().hashCode());
        result = prime * result + ((getMiddleValue() == null) ? 0 : getMiddleValue().hashCode());
        result = prime * result + ((getLowValue() == null) ? 0 : getLowValue().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}