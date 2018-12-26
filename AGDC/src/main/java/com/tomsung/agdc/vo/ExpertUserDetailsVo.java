package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/8/9.
 */
public class ExpertUserDetailsVo {
    private Integer userId = 0;
    private String realName = "";
    private String tel = "";
    private String address = "";
    private Integer sex = 0;
    private Integer age = 0;
    private Integer vip = 0;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getVip() {
        if (vip == 39){
            return 1;
        }else{
            return 0;
        }
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }
}
