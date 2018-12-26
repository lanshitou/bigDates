package com.tomsung.agdc.service;

import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.domain.PlantLog;
import com.tomsung.agdc.vo.BlockOutputRankVo;
import com.tomsung.agdc.vo.PlantLogVO;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/18 10:14
 * @Description:
 */
public interface IPlantService {

    List<Plant> listPull(Integer cropId, Integer blockId);

    List<Crop> listCrop(Integer userId);

    List<Plant> listByUserAndCrop(Integer userId, Integer cropId);

    List<PlantLog> listLog(Integer plantId);

    List<PlantLogVO> listLogByUserId(Integer userId);

    List<BlockOutputRankVo> getBlockOutputRank(String annual, Integer cropId);
}
