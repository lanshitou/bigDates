package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/10/12.
 */
public class BlockIsAutoAreaVo {
    private Double notAutoSumm = new Double(0);
    private Double autoSumm = new Double(0);
    private String address = "";

    public Double getNotAutoSumm() {
        return notAutoSumm;
    }

    public void setNotAutoSumm(Double notAutoSumm) {
        this.notAutoSumm = notAutoSumm;
    }

    public Double getAutoSumm() {
        return autoSumm;
    }

    public void setAutoSumm(Double autoSumm) {
        this.autoSumm = autoSumm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
