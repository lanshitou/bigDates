package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tomsung.agdc.domain.CropGrow;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/11 9:55
 */
public class GrowerDistribute {
    //用户id
    private Integer userId;
    //用户名
    private String growerName;
    //用户地址
    private String province;
    private String city;
    private String district;
    private String addX;
    private String addY;
    //具体信息
    private List<String> info;
    //详情
    @JsonIgnore
    private List<Detail> details;

    public static class Detail {
        //作物名
        private String plantName;
        //种植面积
        private BigDecimal area;
        //阶段名
        private String periodName;
        //发芽时间
        @JsonIgnore
        private Date sproutTime;
        //存放阶段时间的位置
        @JsonIgnore
        private List<CropGrow> cropGrows;

        public String getPlantName() {
            return plantName;
        }

        public void setPlantName(String plantName) {
            this.plantName = plantName;
        }

        public BigDecimal getArea() {
            return area;
        }

        public void setArea(BigDecimal area) {
            this.area = area;
        }

        public String getPeriodName() {
            return periodName;
        }

        public void setPeriodName(String periodName) {
            this.periodName = periodName;
        }

        public Date getSproutTime() {
            return sproutTime;
        }

        public void setSproutTime(Date sproutTime) {
            this.sproutTime = sproutTime;
        }

        public List<CropGrow> getCropGrows() {
            return cropGrows;
        }

        public void setCropGrows(List<CropGrow> cropGrows) {
            this.cropGrows = cropGrows;
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGrowerName() {
        return growerName;
    }

    public void setGrowerName(String growerName) {
        this.growerName = growerName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public String getAddX() {
        return addX;
    }

    public void setAddX(String addX) {
        this.addX = addX;
    }

    public String getAddY() {
        return addY;
    }

    public void setAddY(String addY) {
        this.addY = addY;
    }
}
