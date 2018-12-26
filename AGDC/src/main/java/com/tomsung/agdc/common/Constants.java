package com.tomsung.agdc.common;

public class Constants {

    public static final String YEAR = "年";
    public static final String MONTH = "月";
    public static final String DAY = "日";
    public static final String HOUR = "点";
    public static final String MU = "亩";
    public static final int FORMONTH = 6;
    public static final int ONE_MONTH = 30;
    public static final int THREE_MONTH = 90;
    public static final int ONE_HALF_YEAR = 365 + 183;

    /* 土壤元素单位所需常量 */
    public static final byte UNIT_ELEMENT_CONTENT = 1; // mg/L
    public static final byte UNIT_FERTILIZATION = 4; // kg/亩

    /* 土壤对比结果所需常量 */
    public static final String SOIL_LEVEL5 = "土壤质量很好,不需要施肥";
    public static final String SOIL_LEVEL3 = "土壤质量一般,需要施肥";
    public static final String SOIL_LEVEL1 = "土壤质量差,需要施肥";
    public static final String HAS_BEEN_GAIN = "已收获";

    /* 土壤特殊元素所需常量 */
    public static final int CALCIUM_MAGNESIUM_RATIO = 16; //钙镁比
    public static final int MAGNESIUM_KALIUM_RATIO = 17; //镁钾比


}
