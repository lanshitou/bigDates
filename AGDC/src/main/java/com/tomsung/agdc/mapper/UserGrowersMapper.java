package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.UserGrowers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserGrowersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserGrowers record);

    int insertSelective(UserGrowers record);

    UserGrowers selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserGrowers record);

    int updateByPrimaryKey(UserGrowers record);
}