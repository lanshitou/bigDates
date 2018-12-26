package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.Date;

public class SaleDetailInfoVo {

	public String productName = "";
	public BigDecimal saleNum = new BigDecimal(0);
	public BigDecimal salePrice = new BigDecimal(0);
	public BigDecimal saleWeight = new BigDecimal(0);
	public Date saleTime = null;
	public String provinceName = "";
	public String cityName = "";
	public String districtName = "";
	public String address = "";
}
