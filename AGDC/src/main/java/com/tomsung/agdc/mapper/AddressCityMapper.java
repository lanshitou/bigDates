package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.AddressCity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AddressCityMapper {
    int deleteByPrimaryKey(String code);

    int insert(AddressCity record);

    int insertSelective(AddressCity record);

    AddressCity selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(AddressCity record);

    int updateByPrimaryKey(AddressCity record);

    List<AddressCity> selectGrowersByProvince(@Param("provinceCode") String provinceCode);
}