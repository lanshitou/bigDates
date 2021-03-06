package com.tomsung.agdc.domain;

public class DistrictKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column DISTRICT.DISTRICTID
	 * @mbg.generated
	 */
	private Integer districtid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column DISTRICT.CITYID
	 * @mbg.generated
	 */
	private Integer cityid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column DISTRICT.DISTRICTID
	 * @return  the value of DISTRICT.DISTRICTID
	 * @mbg.generated
	 */
	public Integer getDistrictid() {
		return districtid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column DISTRICT.DISTRICTID
	 * @param districtid  the value for DISTRICT.DISTRICTID
	 * @mbg.generated
	 */
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column DISTRICT.CITYID
	 * @return  the value of DISTRICT.CITYID
	 * @mbg.generated
	 */
	public Integer getCityid() {
		return cityid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column DISTRICT.CITYID
	 * @param cityid  the value for DISTRICT.CITYID
	 * @mbg.generated
	 */
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DISTRICT
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
		DistrictKey other = (DistrictKey) that;
		return (this.getDistrictid() == null ? other.getDistrictid() == null
				: this.getDistrictid().equals(other.getDistrictid()))
				&& (this.getCityid() == null ? other.getCityid() == null : this.getCityid().equals(other.getCityid()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DISTRICT
	 * @mbg.generated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDistrictid() == null) ? 0 : getDistrictid().hashCode());
		result = prime * result + ((getCityid() == null) ? 0 : getCityid().hashCode());
		return result;
	}
}