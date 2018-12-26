package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/25 19:15
 */
public class StationMembersVO {
    private BigDecimal totalLoanMoney;
    private List<InnerClass> inner;

    public static class InnerClass {
        private String userName;
        private BigDecimal plantArea;
        private Integer isLoan;
        private BigDecimal loanMoney;
        private Date loanTime;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public BigDecimal getPlantArea() {
            return plantArea;
        }

        public void setPlantArea(BigDecimal plantArea) {
            this.plantArea = plantArea;
        }

        public Integer getIsLoan() {
            return isLoan;
        }

        public void setIsLoan(Integer isLoan) {
            this.isLoan = isLoan;
        }

        public BigDecimal getLoanMoney() {
            return loanMoney;
        }

        public void setLoanMoney(BigDecimal loanMoney) {
            this.loanMoney = loanMoney;
        }

        public Date getLoanTime() {
            return loanTime;
        }

        public void setLoanTime(Date loanTime) {
            this.loanTime = loanTime;
        }
    }

    public BigDecimal getTotalLoanMoney() {
        return totalLoanMoney;
    }

    public void setTotalLoanMoney(BigDecimal totalLoanMoney) {
        this.totalLoanMoney = totalLoanMoney;
    }

    public List<InnerClass> getInner() {
        return inner;
    }

    public void setInner(List<InnerClass> inner) {
        this.inner = inner;
    }
}
