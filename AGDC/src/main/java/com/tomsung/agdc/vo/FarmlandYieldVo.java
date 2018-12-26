package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FarmlandYieldVo {

	public Integer farmlandid = -1;
	public String farmName = "";
	// 实际产量
	public BigDecimal plantYield = new BigDecimal(0);
	// 预计产量
	public BigDecimal farmYield = new BigDecimal(0);
	// 种植时间
	public Date plantTime;
	
}
