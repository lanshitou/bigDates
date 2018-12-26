package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.Impair;

public interface ImpairMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Impair record);

    int insertSelective(Impair record);

    Impair selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Impair record);

    int updateByPrimaryKey(Impair record);
}