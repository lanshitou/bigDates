package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.domain.UserMatter;
import com.tomsung.agdc.service.*;
import com.tomsung.agdc.service.impl.DeviceServiceImpl;
import com.tomsung.agdc.service.impl.SoilServiceImpl;
import com.tomsung.agdc.vo.CropCountVO;
import com.tomsung.agdc.vo.DeviceCountVo;
import com.tomsung.agdc.vo.MemberCountVO;
import com.tomsung.agdc.vo.PlantLogVO;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/10 18:24
 */
@RestController
@RequestMapping("/sys/bigdata_center")
public class BigDataCenterController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICropService cropService;
    @Autowired
    private IUserMatterService userMatterService;
    @Autowired
    DeviceServiceImpl deviceService;
    @Autowired
    SoilServiceImpl soilServiceImpl;
    @Autowired
    IBlockService IBlockService;
    @Autowired
    private IPlantService plantService;

    @GetMapping("/member_count")
    @ApiOperation(value = "会员统计")
    public Object getMemberCount() {
        MemberCountVO memberCountVO = userService.selectMemberCount();
        if (memberCountVO != null) {
            return ResultModel.ok(memberCountVO);
        } else {
            return ResultModel.ok(new MemberCountVO());
        }
    }

    @GetMapping("/contain_crop")
    @ApiOperation(value = "覆盖作物百分比")
    public Object getCropCount() {
        List<CropCountVO> cropCountVO = cropService.getCropCountVO();
        return ResultModel.ok(cropCountVO);
    }

    @GetMapping("/user_matter")
    @ApiOperation(value = "农业资讯")
    public Object listUserMatter() {

        List<UserMatter> list = userMatterService.listAll();

        return ResultModel.ok(list);
    }

    @GetMapping("/get_device_count")
    @ApiOperation("获取设备数量")
    public Object getDeviceCount() {
        List<DeviceCountVo> deviceCount = deviceService.getDeviceCount();
        if (CollectionUtils.isNotEmpty(deviceCount)) {
            return ResultModel.ok(deviceCount);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_soil_detail")
    @ApiOperation("获取测土详情")
    public Object getSoilDetail(@RequestParam("userId") Integer userId) {
        return ResultModel.ok(soilServiceImpl.getSoilDetail(userId));
    }

    @GetMapping("/grower_distribute")
    @ApiOperation(value = "种植户分布及详情")
    public Object getGrowerDistribute() {
        return ResultModel.ok(userService.selectGrowerDistribute());
    }

    @GetMapping("/get_block_video_by_block_id")
    @ApiOperation(value = "获取园区视频")
    public Object getGrowerDistribute(@RequestParam("userId") Integer userId,Integer blockId) {
        return ResultModel.ok(IBlockService.getBlockVideoByBlockId(userId,blockId));
    }

    @GetMapping("/get_planting_log")
    @ApiOperation("获取农事追溯")
    public Object getPlantingLog(@RequestParam("userId") Integer userId) {
        List<PlantLogVO> list = plantService.listLogByUserId(userId);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

}
