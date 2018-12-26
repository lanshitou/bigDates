package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.Constants;
import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.domain.*;
import com.tomsung.agdc.service.IAddressService;
import com.tomsung.agdc.service.ISoilService;
import com.tomsung.agdc.service.IUserService;
import com.tomsung.agdc.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/6 14:31
 * @Description: 土壤信息相关接口
 */
@RestController
@RequestMapping("/sys/soil")
public class SoilController {

    @Autowired
    private ISoilService soilService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IUserService userService;

    @PostMapping("/standard_pull_list")
    @ApiOperation(value = "标准量下拉列表")
    public Object soilStandardPullList(Integer blockId) {

        List<SoilStandard> list = soilService.listPullSoilStandard(blockId);

        return ResultModel.ok(list);
    }

    @PostMapping("/standard_detail")
    @ApiOperation(value = "标准量详情")
    public Object soilStandardDetail(Integer id) {

        SoilStandardDetailVO vo = soilService.getSoilStandardDetail(id);

        return ResultModel.ok(vo);
    }

    @PostMapping("/block_soil_top3")
    @ApiOperation(value = "最新3条土壤检测结果")
    public Object blockSoilTop3List(Integer blockId) {

        List<BlockSoil> list = soilService.listBlockSoilTop3(blockId);

        return ResultModel.ok(list);
    }

    @PostMapping("/block_soil_detail")
    @ApiOperation(value = "土壤检测结果详情")
    public Object blockSoilDetail(Integer blockSoilId) {

        BlockSoilDetailVO vo = soilService.getBlockSoilDetail(blockSoilId);

        return ResultModel.ok(vo);
    }

    @PostMapping("/fertilization_suggest")
    @ApiOperation(value = "土壤元素缺失量")
    public Object fertilizationSuggest(Integer blockSoilId, Integer standardId) {

        List<BlockFertilizationItem> list = soilService.listFertilizationItem(blockSoilId, standardId);

        return ResultModel.ok(list);
    }

    @PostMapping("/contrast_result")
    @ApiOperation(value = "土壤对比结果")
    public Object contrastResult(Integer blockSoilId, Integer standardId) {

        List<BlockFertilizationItem> list = soilService.listFertilizationItem(blockSoilId, standardId);
        ContrastResultVO vo = new ContrastResultVO();
        int count = list.size();
        if (count == 0) {
            vo.setContent(Constants.SOIL_LEVEL5);
            vo.setValue(5);
        } else if (count <= 3) {
            vo.setContent(Constants.SOIL_LEVEL3);
            vo.setValue(3);
        }else {
            vo.setContent(Constants.SOIL_LEVEL1);
            vo.setValue(1);
        }

        return ResultModel.ok(vo);
    }

    @PostMapping("/data_contrast")
    @ApiOperation(value = "土壤数据对比")
    public Object dataContrast(Integer blockSoilId, Integer standardId){

        List<SoilItemContrastVO> list = soilService.listContrast(blockSoilId,standardId);

        return ResultModel.ok(list);
    }

    @PostMapping("/suggestion")
    @ApiOperation("推荐施肥方案")
    public Object getSuggestion(Integer standardId){

        SuggestionVO vo = soilService.getSuggestion(standardId);

        return ResultModel.ok(vo);
    }

    @PostMapping("/grower_search")
    @ApiOperation("种植户搜索")
    public Object growersSearch(String realName){

        List<User> list = soilService.listGrowers(realName);

        return ResultModel.ok(list);
    }

    @PostMapping("/grower_province")
    @ApiOperation("种植户省份")
    public Object growersProvince(){

        List<AddressProvince> list = addressService.listGrowersProvince();

        return ResultModel.ok(list);
    }

    @PostMapping("/grower_city")
    @ApiOperation("种植户城市下拉列表")
    public Object growersCity(String provinceCode){

        List<AddressCity> list = addressService.listGrowersCity(provinceCode);

        return ResultModel.ok(list);
    }

    @PostMapping("/grower_area")
    @ApiOperation("种植户区县下拉列表")
    public Object growersArea(String cityCode){

        List<AddressArea> list = addressService.listGrowersArea(cityCode);

        return ResultModel.ok(list);
    }

    @PostMapping("/grower_pull_list")
    @ApiOperation("种植户下拉列表")
    public Object growersPullList(String areaCode){

        List<User> list = soilService.listGrowersPull(areaCode);

        return ResultModel.ok(list);
    }

    @PostMapping("/get_address")
    @ApiOperation("种植户地址")
    public Object getAddress(Integer userId){

        User user = userService.getUser(userId);
        AddressVO vo = addressService.getAddress(user.getAreaCode());

        return ResultModel.ok(vo);
    }

}
