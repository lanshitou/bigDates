package com.tomsung.agdc.vo;


import java.math.BigDecimal;

/**
 * Created by Lvpin on 2018/9/11.
 */
public class ItemVo {
    private Integer id;
    private String name;
    private BigDecimal standardValue = new BigDecimal(0);
    private BigDecimal value = new BigDecimal(0);
    private Integer unit;
    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public BigDecimal getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(BigDecimal standardValue) {
        this.standardValue = standardValue;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}