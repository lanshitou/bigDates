package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.BlockImage;
import com.tomsung.agdc.domain.BlockImageKey;
import com.tomsung.agdc.vo.BlockImageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BlockImageMapper {
    int deleteByPrimaryKey(BlockImageKey key);

    int insert(BlockImage record);

    int insertSelective(BlockImage record);

    BlockImage selectByPrimaryKey(BlockImageKey key);

    int updateByPrimaryKeySelective(BlockImage record);

    int updateByPrimaryKey(BlockImage record);

    List<BlockImageVo> selectBlockImage(@Param("blockId") Integer blockId);
}