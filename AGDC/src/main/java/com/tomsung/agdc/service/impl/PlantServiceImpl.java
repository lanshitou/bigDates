package com.tomsung.agdc.service.impl;

import com.google.common.collect.Lists;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.domain.PlantLog;
import com.tomsung.agdc.mapper.PlantCompactMapper;
import com.tomsung.agdc.mapper.PlantLogMapper;
import com.tomsung.agdc.mapper.PlantMapper;
import com.tomsung.agdc.service.IPlantService;
import com.tomsung.agdc.vo.BlockOutputRankVo;
import com.tomsung.agdc.vo.PlantLogVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Lvpin on 2018/9/11.
 */
@Service
public class PlantServiceImpl implements IPlantService {

    @Autowired
    private PlantMapper plantMapper;
    @Autowired
    private PlantCompactMapper plantCompactMapper;
    @Autowired
    private PlantLogMapper plantLogMapper;

    @Override
    public List<Plant> listPull(Integer cropId, Integer blockId) {

        List<Plant> list = plantMapper.selectByCropIdAndBlockId(cropId, blockId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<Crop> listCrop(Integer userId) {

        List<Crop> list = plantCompactMapper.selectCropByUserId(userId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<Plant> listByUserAndCrop(Integer userId, Integer cropId) {

        List<Plant> list = plantMapper.selectByCropAndUser(cropId, userId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<PlantLog> listLog(Integer plantId) {

        List<PlantLog> list = plantLogMapper.selectByPlantId(plantId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<PlantLogVO> listLogByUserId(Integer userId) {

        List<PlantLog> list = plantLogMapper.selectByUserId(userId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        List<PlantLogVO> result = Lists.newArrayList();
        for (PlantLog plantLog : list) {
            result.add(new PlantLogVO(plantLog));
        }
        return result;
    }

    @Override
    public List<BlockOutputRankVo> getBlockOutputRank(String annual, Integer cropId) {
        return plantCompactMapper.selectBlockOutputRank(annual, cropId);
    }
}
