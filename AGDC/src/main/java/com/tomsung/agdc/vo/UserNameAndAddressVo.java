package com.tomsung.agdc.vo;


import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Lvpin on 2018/8/6.
 */
public class UserNameAndAddressVo {
    private Integer id = new Integer(0);
    private Integer userid = new Integer(0);
    private String username = "";
    private String realusername = "";
    private BigDecimal addX = new BigDecimal(0);
    private BigDecimal addY = new BigDecimal(0);
    private Integer age = new Integer(0);
    private Integer isCompany;
    private List<RoleVo> roleVos;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getIsCompany() {
        return isCompany;
    }

    public void setIsCompany(Integer isCompany) {
        this.isCompany = isCompany;
    }

    public List<RoleVo> getRoleVos() {
        return roleVos;
    }

    public void setRoleVos(List<RoleVo> roleVos) {
        this.roleVos = roleVos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealusername() {
        return realusername;
    }

    public void setRealusername(String realusername) {
        this.realusername = realusername;
    }

    public BigDecimal getAddX() {
        return addX;
    }

    public void setAddX(BigDecimal addX) {
        this.addX = addX;
    }

    public BigDecimal getAddY() {
        return addY;
    }

    public void setAddY(BigDecimal addY) {
        this.addY = addY;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
