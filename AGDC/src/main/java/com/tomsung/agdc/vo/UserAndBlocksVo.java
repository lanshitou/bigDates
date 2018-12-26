package com.tomsung.agdc.vo;


import java.util.List;

/**
 * Created by Lvpin on 2018/9/7.
 */
public class UserAndBlocksVo {
    private Integer userId;
    private String userName;
    private String tel;
    private List<BlockVo> blockVos;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<BlockVo> getBlockVos() {
        return blockVos;
    }

    public void setBlockVos(List<BlockVo> blockVos) {
        this.blockVos = blockVos;
    }
}
