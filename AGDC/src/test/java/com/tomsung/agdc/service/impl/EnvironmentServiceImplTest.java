package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.domain.AirHumidity;
import com.tomsung.agdc.mapper.AirHumidityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvironmentServiceImplTest {
    @Autowired
    EnvironmentServiceImpl environmentServiceImpl;
    @Autowired
    AirHumidityMapper airHumidityMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getTemperatureList() throws ParseException {
//        Temperature tem=new Temperature();
//        tem.setCtrlid(1);
//        tem.setDeviceid(2);
//        tem.setFarmlandid(1);
//        tem.setDevicetype(1);
//        tem.setSystemid(1232423423423L);
//        BigDecimal temdata=new BigDecimal("121.2");
//        tem.setTempdata(temdata);
//        Date date=new SimpleDateFormat("yyyy-MM-dd").parse("2018-3-17");
//        tem.setTime(date);
////        boolean result=environmentServiceImpl.addTemperature(tem);
//        if (result){
//            logger.info("插入数据成功");
//        }else{
//            logger.info("插入数据失败");
//        }
    }

    @Test
    public void getHumidityList() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        for (int i = 0; i < 250; i++) {
            AirHumidity airHumidity = new AirHumidity();
            airHumidity.setDeviceId(i);
            airHumidity.setValue((int) (Math.random() * 20));
            instance.add(Calendar.HOUR,1);
            airHumidity.setTime(instance.getTime());
            airHumidityMapper.insert(airHumidity);
        }
    }

    @Test
    public void getCO2List() {

    }

    @Test
    public void getBeamstrengthList() {
    }

}