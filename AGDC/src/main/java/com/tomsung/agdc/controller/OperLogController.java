package com.tomsung.agdc.controller;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.IOperLogService;
import com.tomsung.agdc.vo.OperateDevLogVo;
import com.tomsung.agdc.vo.OperateLogVo;

import io.swagger.annotations.ApiOperation;


/**
 * 用户信息相关查询接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sys/operlog")
public class OperLogController {

	@Autowired
	private IOperLogService operLogService;
	 
	@GetMapping("/get_all_user_logs")
    @ApiOperation(value = "获取所有用户的操作日志列表")
    public Object getAllOperLogs(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<OperateLogVo> operLogs = operLogService.getOperLogs(pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(operLogs.getList())) {
            return ResultModel.ok(operLogs);
        }
        return ResultModel.error(ResultStatus.ERR_OPER_LOG_NO_DATAS);
    }
	
	@GetMapping("/get_all_farmland_logs")
    @ApiOperation(value = "获取该大棚的操作日志列表")
    public Object getAllFarmlandLogs( 
    		@RequestParam(value = "farmlandId") Integer farmlandId,
    		@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<OperateDevLogVo> operLogs = operLogService.getOperDevLogs(farmlandId, pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(operLogs.getList())) {
            return ResultModel.ok(operLogs);
        }
        return ResultModel.error(ResultStatus.ERR_OPER_DEV_LOG_NO_DATAS);
    }
}
