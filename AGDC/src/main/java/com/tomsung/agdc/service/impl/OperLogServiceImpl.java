package com.tomsung.agdc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.domain.OperateDevLog;
import com.tomsung.agdc.domain.OperateLog;
import com.tomsung.agdc.mapper.OperateDevLogMapper;
import com.tomsung.agdc.mapper.OperateLogMapper;
import com.tomsung.agdc.service.IOperLogService;
import com.tomsung.agdc.vo.OperateDevLogVo;
import com.tomsung.agdc.vo.OperateLogVo;
@Service
public class OperLogServiceImpl implements IOperLogService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	OperateLogMapper operateLogMapper;
	@Autowired
	OperateDevLogMapper operateDevLogMapper;
	
	@Override
	public PageInfo<OperateLogVo> getOperLogs(int pageNum, int pageSize) {
		try
		{
			List<OperateLogVo> logVos = new ArrayList<OperateLogVo>();
			PageHelper.startPage(pageNum, pageSize);
			List<OperateLog> operLogs = operateLogMapper.setAllLog();
			if (operLogs != null)
			{
				for (OperateLog log : operLogs)
				{
					OperateLogVo vo = new OperateLogVo();
					vo.content = log.getContent();
					vo.deviceName = log.getDeivcename();
					vo.farmlandName = log.getFarmlandName();
					vo.operSatus = log.getOperstate();
					vo.time = log.getTime();
					vo.userName = log.getOperator();
					logVos.add(vo);
				}
			}
			return new PageInfo<>(logVos);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return new PageInfo<>(new ArrayList<OperateLogVo>());
	}
	@Override
	public PageInfo<OperateDevLogVo> getOperDevLogs(Integer farmlandId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		try
		{
			List<OperateDevLogVo> logVos = new ArrayList<OperateDevLogVo>();
			List<OperateDevLog> operLogs = operateDevLogMapper.setAllLog();
			if (operLogs != null)
			{
				for (OperateDevLog log : operLogs)
				{
					OperateDevLogVo vo = new OperateDevLogVo();
					vo.deviceName = log.getDeivcename();
					vo.operation = log.getOper();
					vo.time = log.getTime();
					logVos.add(vo);
				}
			}
			return new PageInfo<>(logVos);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return new PageInfo<>(new ArrayList<OperateDevLogVo>());
	}

}
