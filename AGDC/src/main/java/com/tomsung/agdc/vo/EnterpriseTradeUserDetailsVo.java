package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/9/29.
 */
public class EnterpriseTradeUserDetailsVo {
    private String enterpriseName;
    private Integer enterpriseType;
    private String tel;
    private String address;
    private Integer level;
    private Integer subsidies;
    private Integer buyCount;
    private String userUrl;
    private String cropNames;

    public String getCropNames() {
        return cropNames;
    }

    public void setCropNames(String cropNames) {
        this.cropNames = cropNames;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSubsidies() {
        return subsidies;
    }

    public void setSubsidies(Integer subsidies) {
        this.subsidies = subsidies;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
