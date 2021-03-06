package com.tomsung.agdc.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.tomsung.agdc.domain.BeamStrength;
@Mapper
@Component
public interface BeamStrengthMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BEAMSTRENGTH
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BEAMSTRENGTH
	 * @mbg.generated
	 */
	int insert(BeamStrength record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BEAMSTRENGTH
	 * @mbg.generated
	 */
	int insertSelective(BeamStrength record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BEAMSTRENGTH
	 * @mbg.generated
	 */
	BeamStrength selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BEAMSTRENGTH
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(BeamStrength record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table BEAMSTRENGTH
	 * @mbg.generated
	 */
	int updateByPrimaryKey(BeamStrength record);

	List<BeamStrength> selectBeamstrength(
			@Param(value = "farmlandid")Integer farmlandId,
			@Param(value = "beginTime")Date beginTime, 
			@Param(value = "endTime")Date endTime);
}