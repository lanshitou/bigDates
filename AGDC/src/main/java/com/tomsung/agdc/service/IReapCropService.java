package com.tomsung.agdc.service;

import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.domain.ReapCrop;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/18 16:25
 * @Description:
 */
public interface IReapCropService {

    ReapCrop getReapCrop(Integer id);

    List<Crop> listCrop(Integer userId);

    List<Plant> listPlant(Integer cropId,Integer userId);

}
