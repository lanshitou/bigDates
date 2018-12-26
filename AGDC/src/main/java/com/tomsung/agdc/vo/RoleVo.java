package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/9/7.
 */
public class RoleVo {
    private Integer roleId;
    private String name;
    private String description;
    private Integer authTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Integer authTime) {
        this.authTime = authTime;
    }
}
