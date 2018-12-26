package com.tomsung.agdc.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tomsung.agdc.common.Constants;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.*;
import com.tomsung.agdc.mapper.*;
import com.tomsung.agdc.service.ISoilService;
import com.tomsung.agdc.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangqi
 * @Date: 2018/9/6 15:46
 * @Description:
 */
@Service
public class SoilServiceImpl implements ISoilService {

    @Autowired
    private BlockSoilMapper blockSoilMapper;
    @Autowired
    private BlockSoilItemMapper blockSoilItemMapper;
    @Autowired
    private SoilStandardMapper soilStandardMapper;
    @Autowired
    private SoilStandardItemMapper soilStandardItemMapper;
    @Autowired
    private BlockFertilizationItemMapper blockFertilizationItemMapper;
    @Autowired
    private SuggestionMapper suggestionMapper;
    @Autowired
    private SuggestionItemProductMapper suggestionItemProductMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<BlockSoil> listBlockSoilTop3(Integer blockId) {
        return blockSoilMapper.selectTop3ByBlockId(blockId);
    }

    @Override
    public BlockSoilDetailVO getBlockSoilDetail(Integer id) {

        BlockSoil blockSoil = blockSoilMapper.selectByPrimaryKey(id);
        List<BlockSoilItem> items = blockSoilItemMapper.selectByBlockSoilId(id);

        BlockSoilDetailVO vo = new BlockSoilDetailVO(blockSoil);
        vo.setItems(items);

        return vo;
    }

    @Override
    public SoilStandardDetailVO getSoilStandardDetail(Integer id) {

        SoilStandard soilStandard = soilStandardMapper.selectByPrimaryKey(id);
        SoilStandardDetailVO vo = new SoilStandardDetailVO(soilStandard);
        List<SoilStandardItem> items = soilStandardItemMapper.selectByStandardId(id);
        vo.setItems(items);

        return vo;
    }

    @Override
    public List<SoilStandard> listPullSoilStandard(Integer blockId) {

        List<SoilStandard> list = soilStandardMapper.selectByBlockId(blockId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<BlockFertilizationItem> listFertilizationItem(Integer blockSoilId, Integer standardId) {
        //如果数据库中存在则直接返回
        List<BlockFertilizationItem> list = blockFertilizationItemMapper.selectByBlockSoilAndStandard(blockSoilId, standardId);
        if (CollectionUtils.isNotEmpty(list)) {
            return list;
        } else {
            list = Lists.newArrayList();
        }
        //分别查出土壤检测结果和标准量
        List<BlockSoilItem> blockSoilItems = blockSoilItemMapper.selectByBlockSoilId(blockSoilId);
        List<SoilStandardItem> soilStandardItems = soilStandardItemMapper.selectByStandardId(standardId);
        if (CollectionUtils.isEmpty(blockSoilItems) || CollectionUtils.isEmpty(soilStandardItems)) {
            throw new ServiceException(ResultStatus.PARAM_ERR);
        }
        //按照元素逐个计算施肥量,并存入list
        for (SoilStandardItem soilStandardItem : soilStandardItems) {
            if (soilStandardItem.getItemUnit() == Constants.UNIT_ELEMENT_CONTENT) {
                for (BlockSoilItem blockSoilItem : blockSoilItems) {
                    if (blockSoilItem.getItemId().equals(soilStandardItem.getItemId()) ) {
                        BlockFertilizationItem item = (calculate(blockSoilItem, soilStandardItem));
                        if (item != null) {
                            list.add(item);
                        }
                    }
                }
            }
        }
        if (CollectionUtils.isNotEmpty(list)) {
            blockFertilizationItemMapper.insertBatch(list);
        }
        return list;
    }

    private BlockFertilizationItem calculate(BlockSoilItem soilItem, SoilStandardItem standardItem) {
        //如果测量结果大于或等于标准值,则不用施肥
        BigDecimal diff = standardItem.getValue().subtract(soilItem.getValue());
        if (diff.doubleValue() <= 0) {
            return null;
        }
        BlockFertilizationItem item = new BlockFertilizationItem();
        // mg/L 转换 kg/亩(土壤深度30cm)
        BigDecimal quantity = diff.multiply(new BigDecimal(0.5));
        item.setBlockSoilId(soilItem.getBlockSoilId());
        item.setStandardId(standardItem.getSoilStandardId());
        item.setItemId(soilItem.getItemId());
        item.setQuantity(quantity);
        item.setUnit(Constants.UNIT_FERTILIZATION);
        item.setItemName(soilItem.getItemName());
        item.setAbbreviation(soilItem.getAbbreviation());
        return item;
    }

    @Override
    public List<SoilItemContrastVO> listContrast(Integer blockSoilId, Integer standardId) {

        List<BlockSoilItem> SoilItems = blockSoilItemMapper.selectByBlockSoilId(blockSoilId);
        List<SoilStandardItem> standardItems = soilStandardItemMapper.selectByStandardId(standardId);
        if (CollectionUtils.isEmpty(SoilItems) || CollectionUtils.isEmpty(standardItems)) {
            throw new ServiceException(ResultStatus.PARAM_ERR);
        }
        Map<Integer, BigDecimal> map = Maps.newHashMap();
        for (SoilStandardItem standardItem : standardItems) {
            map.put(standardItem.getItemId(), standardItem.getValue());
        }
        List<SoilItemContrastVO> list = Lists.newArrayList();
        for (BlockSoilItem soilItem : SoilItems) {
            SoilItemContrastVO vo = new SoilItemContrastVO();
            vo.setItemId(soilItem.getItemId());
            vo.setItemName(soilItem.getItemName());
            vo.setAbbreviation(soilItem.getAbbreviation());
            //当该项是钙镁比或者镁钾比时需要把该值换算成百分比
            if (soilItem.getItemId() == Constants.CALCIUM_MAGNESIUM_RATIO || soilItem.getItemId() == Constants.MAGNESIUM_KALIUM_RATIO) {
                BigDecimal value = soilItem.getValue().divide(soilItem.getValue().add(new BigDecimal(1)), 3, RoundingMode.DOWN);
                vo.setValue(value.multiply(new BigDecimal(100))); //换算成百分比的值
            } else {
                vo.setValue(soilItem.getValue());
            }
            vo.setUnit(soilItem.getItemUnit());
            BigDecimal standardValue = map.get(soilItem.getItemId());
            vo.setStandardValue(standardValue == null ? new BigDecimal(0.00) : standardValue);
            list.add(vo);
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<SoilItemContentVo> getSoilDetail(Integer userId) {
        List<SoilItemContentVo> surveyContentVos = blockSoilItemMapper.selectSurveyContent(userId);
        for (SoilItemContentVo soilItemContentVo : surveyContentVos) {
            List<ItemVo> itemVos = soilItemContentVo.getItemVos();
            List<ItemVo> itemVos1 = blockSoilItemMapper.selectStandardContent(soilItemContentVo.getCropId());
            for (ItemVo itemVo : itemVos) {
                for (ItemVo item : itemVos1) {
                    if (item.getId().equals(itemVo.getId())) {
                        itemVo.setStandardValue(item.getValue());
                    }
                }
            }
        }

        return surveyContentVos;
    }

    @Override
    public SuggestionVO getSuggestion(Integer standardId) {
        SoilStandard soilStandard = soilStandardMapper.selectById(standardId);
        if (soilStandard == null) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        List<Suggestion> suggestionList = suggestionMapper.selectLikeName(soilStandard.getCropName());
        if (CollectionUtils.isEmpty(suggestionList)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        Suggestion suggestion = suggestionList.get(0);
        SuggestionVO result = new SuggestionVO();
        result.setName(suggestion.getName());
        List<SuggestionItemProduct> productList = suggestionItemProductMapper.selectSuggestionId(suggestion.getId());
        result.setProductList(productList);

        return result;
    }

    @Override
    public List<User> listGrowers(String realName) {
        List<User> list = userMapper.selectGrowersLikeRealName(realName);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        return list;
    }

    @Override
    public List<User> listGrowersPull(String areaCode) {

        List<User> list = userMapper.selectGrowersByAreaCode(areaCode);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        return list;
    }
}
