package com.tomsung.agdc.vo;

import java.util.List;
import java.util.Set;

/**
 * Created by Lvpin on 2018/9/21.
 */
public class ImpairVo {
    private Integer id;
    private String name;
    private Integer count;
    private Set month;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set getMonth() {
        return month;
    }

    public void setMonth(Set month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
