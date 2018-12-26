package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Lvpin on 2018/8/9.
 */
public class FarmerUserDetailsVo {
    private Integer userId = 0;
    private String realusername;
    private String sex;
    private Integer age = 0;
    private String tel;
    private String address;
    private String adminName;
    private Integer plantLevel = 0;
    private Integer creditLevel = 0;
    private Integer leaseDemand = 0;
    private Integer isLoans = 0;
    private BigDecimal loansMoney = new BigDecimal(0);
    private Date loansTime = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url = "";

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealusername() {
        return realusername;
    }

    public void setRealusername(String realusername) {
        this.realusername = realusername;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getPlantLevel() {
        return plantLevel;
    }

    public void setPlantLevel(Integer plantLevel) {
        this.plantLevel = plantLevel;
    }

    public Integer getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(Integer creditLevel) {
        this.creditLevel = creditLevel;
    }

    public Integer getLeaseDemand() {
        return leaseDemand;
    }

    public void setLeaseDemand(Integer leaseDemand) {
        this.leaseDemand = leaseDemand;
    }

    public Integer getIsLoans() {
        return isLoans;
    }

    public void setIsLoans(Integer isLoans) {
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
}
