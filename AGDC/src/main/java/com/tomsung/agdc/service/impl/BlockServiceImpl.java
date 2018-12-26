package com.tomsung.agdc.service.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.CropGrow;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.mapper.*;
import com.tomsung.agdc.service.IBlockService;
import com.tomsung.agdc.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lvpin on 2018/8/13.
 */
@Service
public class BlockServiceImpl implements IBlockService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BlockVideoMapper blockVideoMapper;
    @Autowired
    private CropMapper cropMapper;
    @Autowired
    private PlantMapper plantMapper;
    @Autowired
    private CropGrowMapper cropGrowMapper;
    @Autowired
    private BlockImageMapper blockImageMapper;
    @Autowired
    private BlockImpairMapper blockImpairMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private PlantCompactMapper plantCompactMapper;

    /**
     * 获取种植户的园区列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<BlockVo> getBlockListByUserId(Integer userId) {
        try {
            List<BlockVo> blockVos = blockMapper.selectBlockListByUserId(userId);
            if (CollectionUtils.isNotEmpty(blockVos)) {
                return blockVos;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new ArrayList();
    }

    /**
     * 获取园区概览（种植信息）
     *
     * @param blockId
     * @return
     */
    @Override
    public List<OverviewVo> getOverviewByblockId(Integer blockId) {
        try {
            List<OverviewVo> overviewVos = blockMapper.selectOverviewByblockId(blockId);
            if (CollectionUtils.isNotEmpty(overviewVos)) {
                return overviewVos;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new ArrayList();
    }

    @Override
    public UserBlockVo getDetailByBlockId(Integer blockId) {
        List<UserBlockVo> userBlockVos = blockMapper.selectDetailByBlockId(blockId);
        UserBlockVo userBlockVo1 = new UserBlockVo();
        Joiner on = Joiner.on(",");
        List<String> cropNames = new ArrayList<>();
        if (userBlockVos != null) {
            for (UserBlockVo userBlockVo : userBlockVos) {
                userBlockVo1.setAddress(userBlockVo.getAddress());
                userBlockVo1.setBlockArea(userBlockVo.getBlockArea());
                userBlockVo1.setBlockId(userBlockVo.getBlockId());
                cropNames.add(userBlockVo.getCropName());
                userBlockVo1.setTel(userBlockVo.getTel());
                userBlockVo1.setUserName(userBlockVo.getUserName());
            }
            userBlockVo1.setCropName(on.skipNulls().join(cropNames));
        }
        return userBlockVo1;
    }

    @Override
    public List<BlockVideoVo> getBlockVideoByBlockId(Integer userId, Integer blockId) {
        return blockVideoMapper.selectVideoByBlockId(userId, blockId);
    }

    @Override
    public List<BlockRankVo> getBlockRank() {
        return blockMapper.selectBlockRank();
    }

    @Override
    public List<Crop> listCrop(Integer blockId) {

        List<Crop> list = cropMapper.selectByBlockId(blockId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public CropGrowVO getCropGrow(Integer plantId) {

        Plant plant = plantMapper.selectById(plantId);
        if (plant == null) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        List<CropGrow> cropGrowList = cropGrowMapper.selectCropGrowByCropId(plant.getCropId());
        if (CollectionUtils.isEmpty(cropGrowList)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        List<CropGrowItemVO> items = Lists.newArrayList();
        Calendar sproutCal = Calendar.getInstance();
        sproutCal.setTime(plant.getSproutTime());
        Calendar nowCal = Calendar.getInstance();
        int days = nowCal.get(Calendar.DAY_OF_YEAR) - sproutCal.get(Calendar.DAY_OF_YEAR);
        if (days < 0) {
            throw new ServiceException(ResultStatus.SYSTEM_ERR);
        }
        int totalDays = 0;
        for (CropGrow cropGrow : cropGrowList) {
            totalDays += cropGrow.getStageDays();
            CropGrowItemVO vo = new CropGrowItemVO(cropGrow);
            vo.setWidth(days * 100 / cropGrow.getStageDays());
            if (days >= cropGrow.getStageDays()) {
                vo.setWidth(100); //宽度为100%
                days -= cropGrow.getStageDays();
                vo.setStep(true);
            } else if (days < cropGrow.getStageDays() && days != 0) {
                days = 0;
                vo.setStep(true);
            } else if (days == 0) {
                vo.setWidth(0);
                vo.setStep(false);
            }
            items.add(vo);
        }
        CropGrowVO result = new CropGrowVO();
        result.setSproutTime(plant.getSproutTime());
        Calendar ripeTime = Calendar.getInstance();
        ripeTime.setTime(plant.getSproutTime());
        ripeTime.add(Calendar.DAY_OF_YEAR, totalDays);
        result.setRipeTime(ripeTime.getTime());
        result.setItems(items);
        return result;
    }

    @Override
    public List<BlockImageVo> getBlockImage(Integer blockId) {
        return blockImageMapper.selectBlockImage(blockId);
    }

    @Override
    public List<ImpairAnnualVo> getImpairAnnual(Integer blockId) {
        return blockImpairMapper.selectImpairAnnual(blockId);
    }

    @Override
    public List<ImpairVo> getImpair(Integer blockId, String annual) {
        List<ImpairVo> impairVos = blockImpairMapper.selectImpair(blockId, annual);
        for (ImpairVo impairVo : impairVos) {
            List<MonthVo> getmonth = blockImpairMapper.getmonth(impairVo.getId(), blockId, annual);
            impairVo.setMonth(new HashSet(getmonth));
        }
        return impairVos;
    }

    @Override
    public List<BlockDataShowVo> getCardData() {
        List<BlockDataShowVo> blockDataShowVos = new ArrayList<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            String nowDate = simpleDateFormat.format(new Date());
            BlockDataShowVo vo = new BlockDataShowVo();
            vo.setName("部署城市数目：");
            vo.setCount(blockMapper.selectBlockCityCount(null));
            vo.setMonthCount(blockMapper.selectBlockCityCount(null) - blockMapper.selectBlockCityCount(simpleDateFormat.parse(nowDate)));
            blockDataShowVos.add(vo);

            BlockDataShowVo vo1 = new BlockDataShowVo();
            vo1.setName("覆盖大棚/地块总数：");
            vo1.setCount(blockMapper.selectBlockCount(null));
            vo1.setMonthCount(blockMapper.selectBlockCount(simpleDateFormat.parse(nowDate)));
            blockDataShowVos.add(vo1);

            BlockDataShowVo vo2 = new BlockDataShowVo();
            vo2.setName("总设备数：");
            vo2.setCount(deviceMapper.selectDeviceCount(null));
            vo2.setMonthCount(deviceMapper.selectDeviceCount(simpleDateFormat.parse(nowDate)));
            blockDataShowVos.add(vo2);

            BlockDataShowVo vo3 = new BlockDataShowVo();
            vo3.setName("地块总产量：");
            vo3.setCount(plantMapper.selectOutputSum(null));
            vo3.setMonthCount(plantMapper.selectOutputSum(simpleDateFormat.parse(nowDate)));
            blockDataShowVos.add(vo3);

            BlockDataShowVo vo4 = new BlockDataShowVo();
            vo4.setName("总计划数：");
            vo4.setCount(124);
            vo4.setMonthCount(10);
            blockDataShowVos.add(vo4);

            BlockDataShowVo vo5 = new BlockDataShowVo();
            vo5.setName("覆盖总作物种类：");
            vo5.setCount(plantCompactMapper.selectCropCount(null));
            vo5.setMonthCount(plantCompactMapper.selectCropCount(null) - plantCompactMapper.selectCropCount(simpleDateFormat.parse(nowDate)));
            blockDataShowVos.add(vo5);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return blockDataShowVos;
    }

    @Override
    public List<BlockDataMapVo> getBlockDataMap() {
        List<BlockDataMapVo> blockDataMapVos = blockMapper.selectBlockDataMap(0);
        for (BlockDataMapVo blockDataMapVo : blockDataMapVos) {
            blockDataMapVo.setIsAuto(0);
        }
        List<BlockDataMapVo> blockDataMapVos1 = blockMapper.selectBlockDataMap(1);
        for (BlockDataMapVo blockDataMapVo : blockDataMapVos1) {
            blockDataMapVo.setIsAuto(1);
        }
        blockDataMapVos.addAll(blockDataMapVos1);
        return blockDataMapVos;
    }

    @Override
    public List<RankVo> listBlockAcreYield(Date time, Integer cropId) {
        //获取time中年份的第一天
        Calendar begin = Calendar.getInstance();
        begin.setTime(time);
        begin.set(Calendar.DAY_OF_YEAR,begin.getActualMinimum(Calendar.DAY_OF_YEAR));
        //获取time中年份的最后一天
        Calendar end = Calendar.getInstance();
        end.setTime(time);
        end.set(Calendar.DAY_OF_YEAR,end.getActualMaximum(Calendar.DAY_OF_YEAR));
        List<RankVo> list = blockMapper.selectBlockAcreYield(begin.getTime(),end.getTime(),cropId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        return list;
    }

    @Override
    public List<Crop> listAcreYieldPull(Date time) {

        //获取time中年份的第一天
        Calendar begin = Calendar.getInstance();
        begin.setTime(time);
        begin.set(Calendar.DAY_OF_YEAR,begin.getActualMinimum(Calendar.DAY_OF_YEAR));
        //获取time中年份的最后一天
        Calendar end = Calendar.getInstance();
        end.setTime(time);
        end.set(Calendar.DAY_OF_YEAR,end.getActualMaximum(Calendar.DAY_OF_YEAR));

        List<Crop> list = blockMapper.selectAllReapCropByTime(begin.getTime(),end.getTime());
        if (CollectionUtils.isEmpty(list)){
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        return list;
    }

    @Override
    public List<BlockIsAutoAreaVo> getBlocIsAutoArea() {
        return blockMapper.selectBlocIsAutoArea();
    }
}
