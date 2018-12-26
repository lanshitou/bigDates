package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.AirHumidity;
import com.tomsung.agdc.vo.MeteorologicalDataVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AirHumidityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AirHumidity record);

    int insertSelective(AirHumidity record);

    AirHumidity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AirHumidity record);

    int updateByPrimaryKey(AirHumidity record);

    List<MeteorologicalDataVo> selectAirHumidityData(@Param("blockId") Integer blockId, @Param("time") String time);

    List<MeteorologicalDataVo> selectAirTemperatureData(@Param("blockId") Integer blockId, @Param("time") String time);

    List<MeteorologicalDataVo> selectSoilTemperatureData(@Param("blockId") Integer blockId, @Param("time") String time);

    List<MeteorologicalDataVo> selectSoilMostureData(@Param("blockId") Integer blockId, @Param("time") String time);

    List<MeteorologicalDataVo> selectLightData(@Param("blockId") Integer blockId, @Param("time") String time);

    List<MeteorologicalDataVo> selectCo2Data(@Param("blockId") Integer blockId, @Param("time") String time);

    Integer selectAirHumidityDataByMaxDate(@Param("blockId") Integer blockId);

    Integer selectAirTemperatureDataByMaxDate(@Param("blockId") Integer blockId);

    Integer selectSoilTemperatureDataByMaxDate(@Param("blockId") Integer blockId);

    Integer selectSoilMostureDataByMaxDate(@Param("blockId") Integer blockId);

    Integer selectLightDataByMaxDate(@Param("blockId") Integer blockId);

    Integer selectCo2DataByMaxDate(@Param("blockId") Integer blockId);
}