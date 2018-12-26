package com.tomsung.agdc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.tomsung.agdc.domain.Product;
import com.tomsung.agdc.domain.ProductWithBLOBs;
@Mapper
@Component
public interface ProductMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PRODUCT
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer productId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PRODUCT
	 * @mbg.generated
	 */
	int insert(ProductWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PRODUCT
	 * @mbg.generated
	 */
	int insertSelective(ProductWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PRODUCT
	 * @mbg.generated
	 */
	ProductWithBLOBs selectByPrimaryKey(Integer productId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PRODUCT
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(ProductWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PRODUCT
	 * @mbg.generated
	 */
	int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PRODUCT
	 * @mbg.generated
	 */
	int updateByPrimaryKey(Product record);
}