package com.tomsung.agdc.service;

import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.vo.OperateDevLogVo;
import com.tomsung.agdc.vo.OperateLogVo;

public interface IOperLogService {
	PageInfo<OperateLogVo> getOperLogs(int pageNum, int pageSize);

	PageInfo<OperateDevLogVo> getOperDevLogs(Integer farmlandId, Integer pageNum, Integer pageSize);
}
