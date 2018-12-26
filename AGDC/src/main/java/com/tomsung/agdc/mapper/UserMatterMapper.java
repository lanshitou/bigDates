package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.UserMatter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMatterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMatter record);

    int insertSelective(UserMatter record);

    UserMatter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMatter record);

    int updateByPrimaryKey(UserMatter record);

    List<UserMatter> selectAll();
}