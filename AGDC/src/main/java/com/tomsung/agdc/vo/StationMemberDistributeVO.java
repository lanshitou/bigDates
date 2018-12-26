package com.tomsung.agdc.vo;


import java.math.BigDecimal;
import java.util.List;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/25 19:46
 */
public class StationMemberDistributeVO {
    private String name;
    private List<Object> value;

    public static class InnerClass {
        private BigDecimal gpsX;
        private BigDecimal gpsY;
        private String province;
        private String city;
        private String district;
        private Integer userId;
        private String userName;
        private BigDecimal plantArea;

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

        public BigDecimal getPlantArea() {
            return plantArea;
        }

        public void setPlantArea(BigDecimal plantArea) {
            this.plantArea = plantArea;
        }

        public BigDecimal getGpsX() {
            return gpsX;
        }

        public void setGpsX(BigDecimal gpsX) {
            this.gpsX = gpsX;
        }

        public BigDecimal getGpsY() {
            return gpsY;
        }

        public void setGpsY(BigDecimal gpsY) {
            this.gpsY = gpsY;
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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
