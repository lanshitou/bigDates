package com.tomsung.agdc.controller;

import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.domain.Expert;
import com.tomsung.agdc.service.IExpertService;
import com.tomsung.agdc.vo.CountVo;
import com.tomsung.agdc.vo.ExpertListItemVO;
import com.tomsung.agdc.vo.MapVo;
import com.tomsung.agdc.vo.RankVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 专家信息相关查询接口
 * @author mayong
 *
 */
@RestController
@RequestMapping("/sys/expert")
public class ExpertController {

    @Autowired
    IExpertService expertService;

    @GetMapping("/get_expertcount")
    @ApiOperation(value = "获取八个卡片专家数")
    public Object getUserCount() {
        List<CountVo> list = expertService.getCountList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_liveness")
    @ApiOperation(value = "活跃度排名")
    public Object getLiveness() {
        List<RankVo> list = expertService.getLivenessList();
        if (CollectionUtils.isNotEmpty(list)){
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_grade")
    @ApiOperation(value = "评分排名")
    public Object getRank() {
        List<RankVo> list = expertService.getGradeList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_composition")
    @ApiOperation(value = "专家构成")
    public Object getComposition() {
        List<RankVo> list = expertService.getCompositionList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_consistOfCrop")
    @ApiOperation(value = "专家组成按作物")
    public Object getConsistOdCrop() {
        List<RankVo> list = expertService.getConsistOfCrop();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_heating_map")
    @ApiOperation(value = "区域热力分布")
    public Object getHeatingMap() {
        List<MapVo> list = expertService.getHeatingList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_expert_map")
    @ApiOperation(value = "专家分布")
    public Object getExpertMap() {
        List<MapVo> list = expertService.getExpertList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_expert_list")
    @ApiOperation(value = "获取专家列表")
    public Object getAllExpertList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "keyword",required = false) String keyword) {
        PageInfo<ExpertListItemVO> list = expertService.getAllExpertList(pageNum,pageSize,keyword);
        if (CollectionUtils.isNotEmpty(list.getList())) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }
    @GetMapping("/get_expert_detail")
    @ApiOperation(value = "查看专家详情")
    public Object getAllExpertList(@RequestParam Integer id) {
        Expert expert = expertService.getExpertDetail(id);
        if (expert !=null ) {
            return ResultModel.ok(expert);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

}
