package com.tomsung.agdc.common;

//设备类型定义
public enum DevType {
	/**
	 * 电动阀
	 */
	ELEC_VALVE ((byte)0x00,"电动阀"),//
	ELEC_MAGNETIC_VALVE((byte)0x01,"电磁阀"), // 电磁阀
	PUMP((byte)0x02,"水泵"), // 水泵
	FAN((byte)0x03,"风机"), // 风机
	SHUTTER_MACHINE((byte)0x04,"卷帘机"), // 卷帘机
	GROW_LIGHT((byte)0x05,"生长灯"), // 生长灯
	HEALER((byte)0x06,"加热器"),	//加热器
	DEHUMIDIFIER((byte)0x07,"除湿器"),	//除湿器
	
	OP_DEV_ALL((byte)0x3F,"所有可操作设备"), // 所有可操作设备

	SOIL_HUMI_SENSOR((byte)0x40,"土壤湿度传感器"), // 土壤湿度传感器
	SOIL_TEMP_SENSOR((byte)0x41,"土壤温度传感器"), // 土壤温度传感器
	SOIL_H_AND_T_SENSOR((byte)0x42,"土壤温湿度传感器"), // 土壤温湿度传感器
	AIR_HUMI_SENSOR((byte)0x48,"空气湿度传感器"), // 空气湿度传感器
	AIR_TEMP_SENSOR((byte)0x49,"空气温度传感器"), // 空气温度传感器
	AIR_H_AND_T_SENSOR((byte)0x4A,"空气温湿度传感器"), // 空气温湿度传感器
	LIGHT_INTENSITY((byte)0x50,"光照强度传感器"), // 光照强度传感器
	CO2_SENSOR((byte)0x51,"二氧化碳传感器"), //CO2传感器
	SENSOE_ALL((byte)0x7F,"所有传感器"), // 所有传感器

	IUC((byte) 0x80,"首部控制器"), // 首部控制器自身(IUC=智能单元控制器)
	ICT((byte) 0x81,"田间控制器"), // 田间控制器自身(ICT=智能控制终端)
	IUC_AND_ICT((byte) 0x8F,"控制器"), // 所有首部控制器和田间控制器

	DEV_ALL((byte) 0xFF,"所有设备"),// 所有设备
	
	; 
	
	private byte key;
	private String name;
	DevType(byte key, String name)
	{
		this.key = key;
		this.name = name;
	}
	public byte getKey() {
		return key;
	}
	public void setKey(byte key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static String getDevTypeName(byte key)
	{
		for (DevType devType : DevType.values())
		{
			if (devType.key == key)
			{
				return devType.getName();
			}
		}
		return "";
	}
}
