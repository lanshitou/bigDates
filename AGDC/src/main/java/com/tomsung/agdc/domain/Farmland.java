package com.tomsung.agdc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Farmland {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARMLANDID
	 * @mbg.generated
	 */
	private Integer farmlandid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.USERID
	 * @mbg.generated
	 */
	private Integer userid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_NAME
	 * @mbg.generated
	 */
	private String farmName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.CROP_ID
	 * @mbg.generated
	 */
	private Integer cropId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.CROP_TYPE
	 * @mbg.generated
	 */
	private Integer cropType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.GROW_TYPE
	 * @mbg.generated
	 */
	private Integer growType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_TYPE
	 * @mbg.generated
	 */
	private Integer farmType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_TYPE_NAME
	 * @mbg.generated
	 */
	private String farmTypeName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_X
	 * @mbg.generated
	 */
	private BigDecimal farmX;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_Y
	 * @mbg.generated
	 */
	private BigDecimal farmY;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_ADD_PRO
	 * @mbg.generated
	 */
	private String farmAddPro;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_ADD_CITY
	 * @mbg.generated
	 */
	private String farmAddCity;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_ADD_DIST
	 * @mbg.generated
	 */
	private String farmAddDist;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_ADD_OTHER
	 * @mbg.generated
	 */
	private String farmAddOther;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.PLANT_TIME
	 * @mbg.generated
	 */
	private Date plantTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.PLANT_DURATION
	 * @mbg.generated
	 */
	private Integer plantDuration;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.PLANT_YIELD
	 * @mbg.generated
	 */
	private BigDecimal plantYield;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.PLANT_AREA
	 * @mbg.generated
	 */
	private BigDecimal plantArea;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.SOIL_N
	 * @mbg.generated
	 */
	private BigDecimal soilN;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.SOIL_P
	 * @mbg.generated
	 */
	private BigDecimal soilP;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.SOIL_K
	 * @mbg.generated
	 */
	private BigDecimal soilK;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.REMARK
	 * @mbg.generated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.COLLECT_TIME
	 * @mbg.generated
	 */
	private Date collectTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FARMLAND.FARM_YIELD
	 * @mbg.generated
	 */
	private BigDecimal farmYield;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARMLANDID
	 * @return  the value of FARMLAND.FARMLANDID
	 * @mbg.generated
	 */
	public Integer getFarmlandid() {
		return farmlandid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARMLANDID
	 * @param farmlandid  the value for FARMLAND.FARMLANDID
	 * @mbg.generated
	 */
	public void setFarmlandid(Integer farmlandid) {
		this.farmlandid = farmlandid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.USERID
	 * @return  the value of FARMLAND.USERID
	 * @mbg.generated
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.USERID
	 * @param userid  the value for FARMLAND.USERID
	 * @mbg.generated
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_NAME
	 * @return  the value of FARMLAND.FARM_NAME
	 * @mbg.generated
	 */
	public String getFarmName() {
		return farmName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_NAME
	 * @param farmName  the value for FARMLAND.FARM_NAME
	 * @mbg.generated
	 */
	public void setFarmName(String farmName) {
		this.farmName = farmName == null ? null : farmName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.CROP_ID
	 * @return  the value of FARMLAND.CROP_ID
	 * @mbg.generated
	 */
	public Integer getCropId() {
		return cropId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.CROP_ID
	 * @param cropId  the value for FARMLAND.CROP_ID
	 * @mbg.generated
	 */
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.CROP_TYPE
	 * @return  the value of FARMLAND.CROP_TYPE
	 * @mbg.generated
	 */
	public Integer getCropType() {
		return cropType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.CROP_TYPE
	 * @param cropType  the value for FARMLAND.CROP_TYPE
	 * @mbg.generated
	 */
	public void setCropType(Integer cropType) {
		this.cropType = cropType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.GROW_TYPE
	 * @return  the value of FARMLAND.GROW_TYPE
	 * @mbg.generated
	 */
	public Integer getGrowType() {
		return growType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.GROW_TYPE
	 * @param growType  the value for FARMLAND.GROW_TYPE
	 * @mbg.generated
	 */
	public void setGrowType(Integer growType) {
		this.growType = growType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_TYPE
	 * @return  the value of FARMLAND.FARM_TYPE
	 * @mbg.generated
	 */
	public Integer getFarmType() {
		return farmType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_TYPE
	 * @param farmType  the value for FARMLAND.FARM_TYPE
	 * @mbg.generated
	 */
	public void setFarmType(Integer farmType) {
		this.farmType = farmType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_TYPE_NAME
	 * @return  the value of FARMLAND.FARM_TYPE_NAME
	 * @mbg.generated
	 */
	public String getFarmTypeName() {
		return farmTypeName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_TYPE_NAME
	 * @param farmTypeName  the value for FARMLAND.FARM_TYPE_NAME
	 * @mbg.generated
	 */
	public void setFarmTypeName(String farmTypeName) {
		this.farmTypeName = farmTypeName == null ? null : farmTypeName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_X
	 * @return  the value of FARMLAND.FARM_X
	 * @mbg.generated
	 */
	public BigDecimal getFarmX() {
		return farmX;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_X
	 * @param farmX  the value for FARMLAND.FARM_X
	 * @mbg.generated
	 */
	public void setFarmX(BigDecimal farmX) {
		this.farmX = farmX;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_Y
	 * @return  the value of FARMLAND.FARM_Y
	 * @mbg.generated
	 */
	public BigDecimal getFarmY() {
		return farmY;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_Y
	 * @param farmY  the value for FARMLAND.FARM_Y
	 * @mbg.generated
	 */
	public void setFarmY(BigDecimal farmY) {
		this.farmY = farmY;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_ADD_PRO
	 * @return  the value of FARMLAND.FARM_ADD_PRO
	 * @mbg.generated
	 */
	public String getFarmAddPro() {
		return farmAddPro;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_ADD_PRO
	 * @param farmAddPro  the value for FARMLAND.FARM_ADD_PRO
	 * @mbg.generated
	 */
	public void setFarmAddPro(String farmAddPro) {
		this.farmAddPro = farmAddPro;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_ADD_CITY
	 * @return  the value of FARMLAND.FARM_ADD_CITY
	 * @mbg.generated
	 */
	public String getFarmAddCity() {
		return farmAddCity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_ADD_CITY
	 * @param farmAddCity  the value for FARMLAND.FARM_ADD_CITY
	 * @mbg.generated
	 */
	public void setFarmAddCity(String farmAddCity) {
		this.farmAddCity = farmAddCity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_ADD_DIST
	 * @return  the value of FARMLAND.FARM_ADD_DIST
	 * @mbg.generated
	 */
	public String getFarmAddDist() {
		return farmAddDist;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_ADD_DIST
	 * @param farmAddDist  the value for FARMLAND.FARM_ADD_DIST
	 * @mbg.generated
	 */
	public void setFarmAddDist(String farmAddDist) {
		this.farmAddDist = farmAddDist;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_ADD_OTHER
	 * @return  the value of FARMLAND.FARM_ADD_OTHER
	 * @mbg.generated
	 */
	public String getFarmAddOther() {
		return farmAddOther;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_ADD_OTHER
	 * @param farmAddOther  the value for FARMLAND.FARM_ADD_OTHER
	 * @mbg.generated
	 */
	public void setFarmAddOther(String farmAddOther) {
		this.farmAddOther = farmAddOther == null ? null : farmAddOther.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.PLANT_TIME
	 * @return  the value of FARMLAND.PLANT_TIME
	 * @mbg.generated
	 */
	public Date getPlantTime() {
		return plantTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.PLANT_TIME
	 * @param plantTime  the value for FARMLAND.PLANT_TIME
	 * @mbg.generated
	 */
	public void setPlantTime(Date plantTime) {
		this.plantTime = plantTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.PLANT_DURATION
	 * @return  the value of FARMLAND.PLANT_DURATION
	 * @mbg.generated
	 */
	public Integer getPlantDuration() {
		return plantDuration;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.PLANT_DURATION
	 * @param plantDuration  the value for FARMLAND.PLANT_DURATION
	 * @mbg.generated
	 */
	public void setPlantDuration(Integer plantDuration) {
		this.plantDuration = plantDuration;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.PLANT_YIELD
	 * @return  the value of FARMLAND.PLANT_YIELD
	 * @mbg.generated
	 */
	public BigDecimal getPlantYield() {
		return plantYield;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.PLANT_YIELD
	 * @param plantYield  the value for FARMLAND.PLANT_YIELD
	 * @mbg.generated
	 */
	public void setPlantYield(BigDecimal plantYield) {
		this.plantYield = plantYield;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.PLANT_AREA
	 * @return  the value of FARMLAND.PLANT_AREA
	 * @mbg.generated
	 */
	public BigDecimal getPlantArea() {
		return plantArea;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.PLANT_AREA
	 * @param plantArea  the value for FARMLAND.PLANT_AREA
	 * @mbg.generated
	 */
	public void setPlantArea(BigDecimal plantArea) {
		this.plantArea = plantArea;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.SOIL_N
	 * @return  the value of FARMLAND.SOIL_N
	 * @mbg.generated
	 */
	public BigDecimal getSoilN() {
		return soilN;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.SOIL_N
	 * @param soilN  the value for FARMLAND.SOIL_N
	 * @mbg.generated
	 */
	public void setSoilN(BigDecimal soilN) {
		this.soilN = soilN;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.SOIL_P
	 * @return  the value of FARMLAND.SOIL_P
	 * @mbg.generated
	 */
	public BigDecimal getSoilP() {
		return soilP;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.SOIL_P
	 * @param soilP  the value for FARMLAND.SOIL_P
	 * @mbg.generated
	 */
	public void setSoilP(BigDecimal soilP) {
		this.soilP = soilP;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.SOIL_K
	 * @return  the value of FARMLAND.SOIL_K
	 * @mbg.generated
	 */
	public BigDecimal getSoilK() {
		return soilK;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.SOIL_K
	 * @param soilK  the value for FARMLAND.SOIL_K
	 * @mbg.generated
	 */
	public void setSoilK(BigDecimal soilK) {
		this.soilK = soilK;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.REMARK
	 * @return  the value of FARMLAND.REMARK
	 * @mbg.generated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.REMARK
	 * @param remark  the value for FARMLAND.REMARK
	 * @mbg.generated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.COLLECT_TIME
	 * @return  the value of FARMLAND.COLLECT_TIME
	 * @mbg.generated
	 */
	public Date getCollectTime() {
		return collectTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.COLLECT_TIME
	 * @param collectTime  the value for FARMLAND.COLLECT_TIME
	 * @mbg.generated
	 */
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FARMLAND.FARM_YIELD
	 * @return  the value of FARMLAND.FARM_YIELD
	 * @mbg.generated
	 */
	public BigDecimal getFarmYield() {
		return farmYield;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FARMLAND.FARM_YIELD
	 * @param farmYield  the value for FARMLAND.FARM_YIELD
	 * @mbg.generated
	 */
	public void setFarmYield(BigDecimal farmYield) {
		this.farmYield = farmYield;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FARMLAND
	 * @mbg.generated
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Farmland other = (Farmland) that;
		return (this.getFarmlandid() == null ? other.getFarmlandid() == null
				: this.getFarmlandid().equals(other.getFarmlandid()))
				&& (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
				&& (this.getFarmName() == null ? other.getFarmName() == null
						: this.getFarmName().equals(other.getFarmName()))
				&& (this.getCropId() == null ? other.getCropId() == null : this.getCropId().equals(other.getCropId()))
				&& (this.getCropType() == null ? other.getCropType() == null
						: this.getCropType().equals(other.getCropType()))
				&& (this.getGrowType() == null ? other.getGrowType() == null
						: this.getGrowType().equals(other.getGrowType()))
				&& (this.getFarmType() == null ? other.getFarmType() == null
						: this.getFarmType().equals(other.getFarmType()))
				&& (this.getFarmTypeName() == null ? other.getFarmTypeName() == null
						: this.getFarmTypeName().equals(other.getFarmTypeName()))
				&& (this.getFarmX() == null ? other.getFarmX() == null : this.getFarmX().equals(other.getFarmX()))
				&& (this.getFarmY() == null ? other.getFarmY() == null : this.getFarmY().equals(other.getFarmY()))
				&& (this.getFarmAddPro() == null ? other.getFarmAddPro() == null
						: this.getFarmAddPro().equals(other.getFarmAddPro()))
				&& (this.getFarmAddCity() == null ? other.getFarmAddCity() == null
						: this.getFarmAddCity().equals(other.getFarmAddCity()))
				&& (this.getFarmAddDist() == null ? other.getFarmAddDist() == null
						: this.getFarmAddDist().equals(other.getFarmAddDist()))
				&& (this.getFarmAddOther() == null ? other.getFarmAddOther() == null
						: this.getFarmAddOther().equals(other.getFarmAddOther()))
				&& (this.getPlantTime() == null ? other.getPlantTime() == null
						: this.getPlantTime().equals(other.getPlantTime()))
				&& (this.getPlantDuration() == null ? other.getPlantDuration() == null
						: this.getPlantDuration().equals(other.getPlantDuration()))
				&& (this.getPlantYield() == null ? other.getPlantYield() == null
						: this.getPlantYield().equals(other.getPlantYield()))
				&& (this.getPlantArea() == null ? other.getPlantArea() == null
						: this.getPlantArea().equals(other.getPlantArea()))
				&& (this.getSoilN() == null ? other.getSoilN() == null : this.getSoilN().equals(other.getSoilN()))
				&& (this.getSoilP() == null ? other.getSoilP() == null : this.getSoilP().equals(other.getSoilP()))
				&& (this.getSoilK() == null ? other.getSoilK() == null : this.getSoilK().equals(other.getSoilK()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getCollectTime() == null ? other.getCollectTime() == null
						: this.getCollectTime().equals(other.getCollectTime()))
				&& (this.getFarmYield() == null ? other.getFarmYield() == null
						: this.getFarmYield().equals(other.getFarmYield()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FARMLAND
	 * @mbg.generated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getFarmlandid() == null) ? 0 : getFarmlandid().hashCode());
		result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
		result = prime * result + ((getFarmName() == null) ? 0 : getFarmName().hashCode());
		result = prime * result + ((getCropId() == null) ? 0 : getCropId().hashCode());
		result = prime * result + ((getCropType() == null) ? 0 : getCropType().hashCode());
		result = prime * result + ((getGrowType() == null) ? 0 : getGrowType().hashCode());
		result = prime * result + ((getFarmType() == null) ? 0 : getFarmType().hashCode());
		result = prime * result + ((getFarmTypeName() == null) ? 0 : getFarmTypeName().hashCode());
		result = prime * result + ((getFarmX() == null) ? 0 : getFarmX().hashCode());
		result = prime * result + ((getFarmY() == null) ? 0 : getFarmY().hashCode());
		result = prime * result + ((getFarmAddPro() == null) ? 0 : getFarmAddPro().hashCode());
		result = prime * result + ((getFarmAddCity() == null) ? 0 : getFarmAddCity().hashCode());
		result = prime * result + ((getFarmAddDist() == null) ? 0 : getFarmAddDist().hashCode());
		result = prime * result + ((getFarmAddOther() == null) ? 0 : getFarmAddOther().hashCode());
		result = prime * result + ((getPlantTime() == null) ? 0 : getPlantTime().hashCode());
		result = prime * result + ((getPlantDuration() == null) ? 0 : getPlantDuration().hashCode());
		result = prime * result + ((getPlantYield() == null) ? 0 : getPlantYield().hashCode());
		result = prime * result + ((getPlantArea() == null) ? 0 : getPlantArea().hashCode());
		result = prime * result + ((getSoilN() == null) ? 0 : getSoilN().hashCode());
		result = prime * result + ((getSoilP() == null) ? 0 : getSoilP().hashCode());
		result = prime * result + ((getSoilK() == null) ? 0 : getSoilK().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getCollectTime() == null) ? 0 : getCollectTime().hashCode());
		result = prime * result + ((getFarmYield() == null) ? 0 : getFarmYield().hashCode());
		return result;
	}
	
	private User user;
	private Crop crop;
	private double yieldSum;
	private  Integer area;
	private Integer cropCount;
	private Integer raise;
	private Integer farmCount;

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Integer getFarmCount() {
        return farmCount;
    }

    public void setFarmCount(Integer farmCount) {
        this.farmCount = farmCount;
    }

    public Integer getRaise() {
        return raise;
    }

    public void setRaise(Integer raise) {
        this.raise = raise;
    }

    public Integer getCropCount() {
        return cropCount;
    }

    public void setCropCount(Integer cropCount) {
        this.cropCount = cropCount;
    }

    public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public double getYieldSum() {
		return yieldSum;
	}

	public void setYieldSum(double yieldSum) {
		this.yieldSum = yieldSum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}