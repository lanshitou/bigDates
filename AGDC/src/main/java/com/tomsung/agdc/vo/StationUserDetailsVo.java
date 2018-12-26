package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Lvpin on 2018/8/9.
 */
public class StationUserDetailsVo {
    private Integer userId = 0;
    private String realUserName = "";
    private Integer age = 0;
    private Integer sex = 0;
    private String tel = "";
    private String address = "";
    private Integer count = 0;
    private Integer isLoans = 0;
    private BigDecimal loansMoney = new BigDecimal(0);
    private Date loansTime;
    private String cropNames;
    private Integer level;
    private Integer income = 0;
    private String userUrl;

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getCropNames() {
        return cropNames;
    }

    public void setCropNames(String cropNames) {
        this.cropNames = cropNames;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealUserName() {
        return realUserName;
    }

    public void setRealUserName(String realUserName) {
        this.realUserName = realUserName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
