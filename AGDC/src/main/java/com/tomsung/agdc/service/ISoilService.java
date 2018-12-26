package com.tomsung.agdc.service;

import com.tomsung.agdc.domain.BlockFertilizationItem;
import com.tomsung.agdc.domain.BlockSoil;
import com.tomsung.agdc.domain.SoilStandard;
import com.tomsung.agdc.domain.User;
import com.tomsung.agdc.vo.*;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/6 15:45
 * @Description:
 */
public interface ISoilService {

    /**
     * 获取该园区的最近三次土壤检测结果的编号和时间
     *
     * @param blockId
     * @return
     */
    List<BlockSoil> listBlockSoilTop3(Integer blockId);

    /**
     * 获取详细的检测结果
     *
     * @param id
     * @return
     */
    BlockSoilDetailVO getBlockSoilDetail(Integer id);

    /**
     * 获取土壤元素的标准量
     *
     * @param id
     * @return
     */
    SoilStandardDetailVO getSoilStandardDetail(Integer id);

    /**
     * 园区标准量下拉列表
     *
     * @param blockId
     * @return
     */
    List<SoilStandard> listPullSoilStandard(Integer blockId);

    /**
     * 建议施肥列表
     *
     * @param blockSoilId
     * @return
     */
    List<BlockFertilizationItem> listFertilizationItem(Integer blockSoilId, Integer standardId);

    /**
     * 土壤元素对比数据
     *
     * @return
     */
    List<SoilItemContrastVO> listContrast(Integer blockSoilId, Integer standardId);

    /**
     * 测土详情
     *
     * @param userId
     * @return
     */
    List<SoilItemContentVo> getSoilDetail(Integer userId);

    /**
     * 推荐施肥方案
     *
     * @param standardId
     * @return
     */
    SuggestionVO getSuggestion(Integer standardId);

    /**
     * 查询种植户信息
     */
    List<User> listGrowers(String realName);

    /**
     * 种植户下拉列表
     *
     * @param areaCode 区县编号
     * @return
     */
    List<User> listGrowersPull(String areaCode);

}
