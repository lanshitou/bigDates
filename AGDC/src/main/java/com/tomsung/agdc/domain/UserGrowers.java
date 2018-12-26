package com.tomsung.agdc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserGrowers {
    private Integer userId;

    private Integer adminId;

    private Byte plantLevel;

    private Byte creditLevel;

    private Byte leaseDemand;

    private Boolean isLoans;

    private BigDecimal loansMoney;

    private Date loansTime;

    private Date createTime;

    private Date updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Byte getPlantLevel() {
        return plantLevel;
    }

    public void setPlantLevel(Byte plantLevel) {
        this.plantLevel = plantLevel;
    }

    public Byte getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(Byte creditLevel) {
        this.creditLevel = creditLevel;
    }

    public Byte getLeaseDemand() {
        return leaseDemand;
    }

    public void setLeaseDemand(Byte leaseDemand) {
        this.leaseDemand = leaseDemand;
    }

    public Boolean getIsLoans() {
        return isLoans;
    }

    public void setIsLoans(Boolean isLoans) {
        this.isLoans = isLoans;
    }

    public BigDecimal getLoansMoney() {
        return loansMoney;
    }

    public void setLoansMoney(BigDecimal loansMoney) {
        this.loansMoney = loansMoney;
    }

    public Date getLoansTime() {
        return loansTime;
    }

    public void setLoansTime(Date loansTime) {
        this.loansTime = loansTime;
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
        UserGrowers other = (UserGrowers) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getPlantLevel() == null ? other.getPlantLevel() == null : this.getPlantLevel().equals(other.getPlantLevel()))
            && (this.getCreditLevel() == null ? other.getCreditLevel() == null : this.getCreditLevel().equals(other.getCreditLevel()))
            && (this.getLeaseDemand() == null ? other.getLeaseDemand() == null : this.getLeaseDemand().equals(other.getLeaseDemand()))
            && (this.getIsLoans() == null ? other.getIsLoans() == null : this.getIsLoans().equals(other.getIsLoans()))
            && (this.getLoansMoney() == null ? other.getLoansMoney() == null : this.getLoansMoney().equals(other.getLoansMoney()))
            && (this.getLoansTime() == null ? other.getLoansTime() == null : this.getLoansTime().equals(other.getLoansTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getPlantLevel() == null) ? 0 : getPlantLevel().hashCode());
        result = prime * result + ((getCreditLevel() == null) ? 0 : getCreditLevel().hashCode());
        result = prime * result + ((getLeaseDemand() == null) ? 0 : getLeaseDemand().hashCode());
        result = prime * result + ((getIsLoans() == null) ? 0 : getIsLoans().hashCode());
        result = prime * result + ((getLoansMoney() == null) ? 0 : getLoansMoney().hashCode());
        result = prime * result + ((getLoansTime() == null) ? 0 : getLoansTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}