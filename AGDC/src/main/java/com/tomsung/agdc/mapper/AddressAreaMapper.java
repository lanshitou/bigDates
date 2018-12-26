package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.AddressArea;
import com.tomsung.agdc.vo.AddressVO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@Mapper
public interface AddressAreaMapper {
    int deleteByPrimaryKey(String code);

    int insert(AddressArea record);

    int insertSelective(AddressArea record);

    AddressArea selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(AddressArea record);

    int updateByPrimaryKey(AddressArea record);

    List<AddressArea> selectGrowersByCity(@Param("cityCode") String cityCode);

    AddressVO selectAddressByCode(@Param("areaCode")String areaCode);
}