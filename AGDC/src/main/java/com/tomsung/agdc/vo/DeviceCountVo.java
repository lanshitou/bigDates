package com.tomsung.agdc.vo;

/**
 * Created by Lvpin on 2018/9/10.
 */
public class DeviceCountVo {
    private String deviceName = "";
    private Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
