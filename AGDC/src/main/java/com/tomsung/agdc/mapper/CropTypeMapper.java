package com.tomsung.agdc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.tomsung.agdc.domain.CropType;
@Mapper
@Component
public interface CropTypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CROPTYPE
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer cropType);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CROPTYPE
	 * @mbg.generated
	 */
	int insert(CropType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CROPTYPE
	 * @mbg.generated
	 */
	int insertSelective(CropType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CROPTYPE
	 * @mbg.generated
	 */
	CropType selectByPrimaryKey(Integer cropType);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CROPTYPE
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(CropType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CROPTYPE
	 * @mbg.generated
	 */
	int updateByPrimaryKey(CropType record);
}