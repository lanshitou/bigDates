package com.tomsung.agdc.vo;



/**
 * Created by Lvpin on 2018/9/13.
 */
public class SensorVo {
    private String name;
    private Integer value = new Integer(0);
    private Byte type;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
