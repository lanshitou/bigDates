package com.tomsung.agdc.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.IProficientService;
import com.tomsung.agdc.vo.ProficientActivityVo;
import com.tomsung.agdc.vo.ProficientVo;

import io.swagger.annotations.ApiOperation;

/**
 * 专家信息相关查询接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sys/proficient")
public class ProficientController {

	@Autowired
	private IProficientService proficientService;
	 
	@GetMapping("/get_all_proficients")
    @ApiOperation(value = "获取所有专家列表")
    public Object getAllProficients() {
        List<ProficientVo> proficients = proficientService.getAllProficientList();
        if (CollectionUtils.isNotEmpty(proficients)) {
            return ResultModel.ok(proficients);
        }
        return ResultModel.error(ResultStatus.ERR_PROFICENT_NO_DATAS);
    }
	
	@GetMapping("/get_proficient_activity")
    @ApiOperation(value = "获取所有专家活跃程度列表")
    public Object getProficientActivity() {
        List<ProficientActivityVo> proficientActivitys = proficientService.getAllProficientActivityList();
        if (CollectionUtils.isNotEmpty(proficientActivitys)) {
            return ResultModel.ok(proficientActivitys);
        }
        return ResultModel.error(ResultStatus.ERR_PROFICENT_NO_DATAS);
    }
	
	
}
