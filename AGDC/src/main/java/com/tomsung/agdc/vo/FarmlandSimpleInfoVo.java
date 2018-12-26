package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FarmlandSimpleInfoVo {

	public Integer farmlandid = -1;
	// 地块名称
	public String farmName = "";
	// 种植作物名称
	public String cropName = "";
	// 种植时间
	public Date plantTime;
	// 种植产量
	public BigDecimal plantYield = new BigDecimal(0);
	// 预估产量
	public BigDecimal farmYield = new BigDecimal(0);
}
