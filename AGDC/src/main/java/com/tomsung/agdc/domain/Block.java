package com.tomsung.agdc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Block {
    private Integer blockId;

    private Integer gardenNo;

    private Integer userId;

    private String regionAddress;

    private String blockName;

    private Double blockArea;

    private String address;

    private String areaCode;

    private BigDecimal addressX;

    private BigDecimal addressY;

    private Date createTime;

    private Date updateTime;

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getGardenNo() {
        return gardenNo;
    }

    public void setGardenNo(Integer gardenNo) {
        this.gardenNo = gardenNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRegionAddress() {
        return regionAddress;
    }

    public void setRegionAddress(String regionAddress) {
        this.regionAddress = regionAddress == null ? null : regionAddress.trim();
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName == null ? null : blockName.trim();
    }

    public Double getBlockArea() {
        return blockArea;
    }

    public void setBlockArea(Double blockArea) {
        this.blockArea = blockArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public BigDecimal getAddressX() {
        return addressX;
    }

    public void setAddressX(BigDecimal addressX) {
        this.addressX = addressX;
    }

    public BigDecimal getAddressY() {
        return addressY;
    }

    public void setAddressY(BigDecimal addressY) {
        this.addressY = addressY;
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
        Block other = (Block) that;
        return (this.getBlockId() == null ? other.getBlockId() == null : this.getBlockId().equals(other.getBlockId()))
            && (this.getGardenNo() == null ? other.getGardenNo() == null : this.getGardenNo().equals(other.getGardenNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRegionAddress() == null ? other.getRegionAddress() == null : this.getRegionAddress().equals(other.getRegionAddress()))
            && (this.getBlockName() == null ? other.getBlockName() == null : this.getBlockName().equals(other.getBlockName()))
            && (this.getBlockArea() == null ? other.getBlockArea() == null : this.getBlockArea().equals(other.getBlockArea()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getAddressX() == null ? other.getAddressX() == null : this.getAddressX().equals(other.getAddressX()))
            && (this.getAddressY() == null ? other.getAddressY() == null : this.getAddressY().equals(other.getAddressY()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlockId() == null) ? 0 : getBlockId().hashCode());
        result = prime * result + ((getGardenNo() == null) ? 0 : getGardenNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRegionAddress() == null) ? 0 : getRegionAddress().hashCode());
        result = prime * result + ((getBlockName() == null) ? 0 : getBlockName().hashCode());
        result = prime * result + ((getBlockArea() == null) ? 0 : getBlockArea().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getAddressX() == null) ? 0 : getAddressX().hashCode());
        result = prime * result + ((getAddressY() == null) ? 0 : getAddressY().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}