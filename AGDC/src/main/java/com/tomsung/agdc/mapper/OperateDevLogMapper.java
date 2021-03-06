package com.tomsung.agdc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.tomsung.agdc.domain.OperateDevLog;
@Mapper
@Component
public interface OperateDevLogMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table OPERATE_DEV_LOG
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table OPERATE_DEV_LOG
	 * @mbg.generated
	 */
	int insert(OperateDevLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table OPERATE_DEV_LOG
	 * @mbg.generated
	 */
	int insertSelective(OperateDevLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table OPERATE_DEV_LOG
	 * @mbg.generated
	 */
	OperateDevLog selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table OPERATE_DEV_LOG
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(OperateDevLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table OPERATE_DEV_LOG
	 * @mbg.generated
	 */
	int updateByPrimaryKey(OperateDevLog record);

	List<OperateDevLog> setAllLog();
}