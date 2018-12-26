package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.domain.ReapCrop;
import com.tomsung.agdc.mapper.ReapCropMapper;
import com.tomsung.agdc.service.IReapCropService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/18 16:27
 * @Description:
 */
@Service
public class ReapServiceImpl implements IReapCropService {

    @Autowired
    private ReapCropMapper reapCropMapper;

    @Override
    public ReapCrop getReapCrop(Integer id) {

        ReapCrop reapCrop = reapCropMapper.selectByPlantId(id);
        if (reapCrop == null) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return reapCrop;
    }

    @Override
    public List<Crop> listCrop(Integer userId) {

        List<Crop> list = reapCropMapper.selectCropByUserId(userId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<Plant> listPlant(Integer cropId, Integer userId) {

        List<Plant> list = reapCropMapper.selectPlantByCropId(cropId,userId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }
}
