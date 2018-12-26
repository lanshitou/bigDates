package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.BlockVideo;
import com.tomsung.agdc.vo.BlockVideoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BlockVideoMapper {
    int insert(BlockVideo record);

    int insertSelective(BlockVideo record);

    List<BlockVideoVo> selectVideoByBlockId(@Param("userId") Integer userId,@Param("blockId") Integer blockId);
}