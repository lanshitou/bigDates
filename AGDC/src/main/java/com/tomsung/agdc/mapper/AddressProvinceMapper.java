package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.AddressProvince;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AddressProvinceMapper {
    int deleteByPrimaryKey(String code);

    int insert(AddressProvince record);

    int insertSelective(AddressProvince record);

    AddressProvince selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(AddressProvince record);

    int updateByPrimaryKey(AddressProvince record);

    /**
     * 查询所有种植户的所在省份
     *
     * @return
     */
    List<AddressProvince> selectByAllGrowers();
}