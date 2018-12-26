package com.tomsung.agdc.common;

/**
 * 自定义请求状态码
 */
public enum ResultStatus {
    SUCCESS(30000, "成功"),

    SYSTEM_ERR(30001, "服务器异常"),
    NO_DATA(30002,"没有数据"),
    INVALID_TOKEN(30003, "登录过期或者无效，请重新登录"),
    PARAM_ERR(30004, "入参非法"),
    DUPLICATE_KEY_ERR(30005, "已有记录"),

    /* 登录相关错误码 */
    USERNAME_OR_PASSWORD_ERROR(30010, "用户名或密码错误"),
    USER_NOT_FOUND(30011, "用户不存在"),
    USER_NOT_LOGIN(30012, "用户未登录"),

    /* 用户信息查询相关 */
    ERR_USER_NO_DATAS(30020, "要查询的用户信息不存在。"),
    ERR_USER_NO_VIP(30021, "该用户不是VIP用户"),
	
	/* farmland查询相关 */
	ERR_FARMLAND_NO_DATAS(30030, "要查询的大棚或大田信息不存在。"),
	ERR_FARMLAND_XY_NO_DATAS(30031, "要查询的大棚或大田经纬度信息不存在。"),
	ERR_FARMLAND_SIMPLE_NO_DATAS(30032, "要查询的大棚或大田简介信息不存在。"),
	ERR_FARMLAND_DETAIL_NO_DATAS(30033, "要查询的大棚或大田详细信息不存在。"),
	ERR_FARMLAND_YIELD_NO_DATAS(30034, "要查询的大棚或大田详细信息不存在。"),
	ERR_FARMLAND_DEVICE_NO_DATAS(30035, "要查询的大棚或大田详细信息不存在。"),
	
	/* 环境信息查询相关 */
	ERR_TEMP_AIR_NO_DATAS(30040, "要查询的空气温度信息不存在。"),
	ERR_TEMP_SOIL_NO_DATAS(30041, "要查询的土壤温度信息不存在。"),
	ERR_HUMIDITY_AIR_NO_DATAS(30042, "要查询的空气湿度信息不存在。"),
	ERR_HUNIDITY_SOIL_NO_DATAS(30043, "要查询的土壤湿度信息不存在。"),
	ERR_CO2_NO_DATAS(30044, "要查询的二氧化碳信息不存在。"),
	ERR_BEAMSTRENGTH_NO_DATAS(30045, "要查询的光照强度信息不存在。"),
	
	/* 作物信息查询相关 */
	ERR_CROP_NO_DATAS(30060, "要查询的作物生长阶段信息不存在。"),
	
	
	/* 计划查询相关 */
	ERR_PLAN_NO_DATAS(30080, "要查询的计划信息不存在。"),
	ERR_CYCLEPLAN_NO_DATAS(30081, "要查询的周期计划信息不存在。"),
	ERR_AUTOPLAN_NO_DATAS(30082, "要查询的智能计划信息不存在。"),
	
	
	/* 操作日志查询相关 */
	ERR_OPER_LOG_NO_DATAS(30100, "要查询的用户操作日志信息不存在。"),
	ERR_OPER_DEV_LOG_NO_DATAS(30100, "要查询的设备操作日志信息不存在。"),
	
	/* 销售信息查询相关 */
	ERR_SALE_NO_DATAS(30120, "要查询的销售信息不存在。"),
	ERR_SALE_NO_DATAS_ADD(30121, "该区域的销售信息不存在。"),
	
	/* 自提点信息查询相关 */
	ERR_PICKUP_POINT_NO_DATAS(30200, "要查询的自提点信息不存在。"),
	
	/* 专家信息查询相关 */
	ERR_PROFICENT_NO_DATAS(30300, "要查询的自提点信息不存在。"),


    ;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
