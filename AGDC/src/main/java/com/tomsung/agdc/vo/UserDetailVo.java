package com.tomsung.agdc.vo;


import java.util.Date;
import java.util.List;

/**
 * Created by Lvpin on 2018/9/7.
 */
public class UserDetailVo {
    private Integer userId;
    private String realUserName;
    private String sex;
    private Integer age;
    private Integer userType;
    private Integer adminId;
    private String tel;
    private String address;
    private Integer grade;
    private Integer creditLevel;
    private Integer leaseDemand;
    private Integer isLoans;
    private Double loansMoney;
    private Date loansTime;
    private Integer plantLevel;
    private List<RoleVo> roleVos;
    private String adminName;
    private String provinceName;
    private String cityName;
    private String userUrl;
    private String expertLevel;

    public String getExpertLevel() {
        return expertLevel;
    }

    public void setExpertLevel(String expertLevel) {
        this.expertLevel = expertLevel;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    private String districtName;


    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public List<RoleVo> getRoleVos() {
        return roleVos;
    }

    public void setRoleVos(List<RoleVo> roleVos) {
        this.roleVos = roleVos;
    }

    public Integer getPlantLevel() {
        return plantLevel;
    }

    public void setPlantLevel(Integer plantLevel) {
        this.plantLevel = plantLevel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getUserId() {
        return userId;
    }


    public String getRealUserName() {
        return realUserName;
    }

    public void setRealUserName(String realUserName) {
        this.realUserName = realUserName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public Double getLoansMoney() {
        return loansMoney;
    }

    public void setLoansMoney(Double loansMoney) {
        this.loansMoney = loansMoney;
    }

    public Date getLoansTime() {
        return loansTime;
    }

    public void setLoansTime(Date loansTime) {
        this.loansTime = loansTime;
    }
}
