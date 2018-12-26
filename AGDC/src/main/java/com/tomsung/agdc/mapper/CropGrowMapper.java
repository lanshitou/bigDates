package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.CropGrow;
import com.tomsung.agdc.domain.CropGrowKey;
import com.tomsung.agdc.vo.CropCountVO;
import com.tomsung.agdc.vo.CropStageInBlockVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CropGrowMapper {
    int deleteByPrimaryKey(CropGrowKey key);

    int insert(CropGrow record);

    int insertSelective(CropGrow record);

    CropGrow selectByPrimaryKey(CropGrowKey key);

    int updateByPrimaryKeySelective(CropGrow record);

    int updateByPrimaryKey(CropGrow record);

    List<CropStageInBlockVo> selectCropStage(@Param("blockId") Integer blockId);

    List<CropCountVO> selectCropCountVO();

    List<CropGrow> selectCropGrowByCropId(@Param("cropId") Integer cropId);
}