package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.PlantLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author: zhangqi
 * @Date: 2018/10/12 9:26
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlantLogMapperTest {

    @Autowired
    private PlantLogMapper plantLogMapper;

    @Test
    public void insertSelective() {
        List<PlantLog> list = plantLogMapper.selectAll();
        for (PlantLog plantLog : list) {
            Random random = new Random();
            int i = random.nextInt(3);
            plantLog.setPlantType("施肥");
            if (i == 0){
                plantLog.setPlantDetail("施肥：氮磷钾");
            }else if(i==2){
                plantLog.setPlantDetail("施肥：氮肥");
            }else{
                plantLog.setPlantDetail("施肥：施催芽肥");
            }

            plantLog.setPlantTime(1533686400 - (random.nextInt(7776000)));
            plantLog.setPlantImages("hangzhou.aliyuncs.com/images/2018/10/10/07692aaf49968bf8e02ecfe28251984c.JPG");
            plantLog.setResult((byte) (random.nextInt(3) + 1));
            plantLog.setCreateTime(new Date());
            plantLog.setUpdateTime(new Date());
            plantLogMapper.insertSelective(plantLog);

        }

    }
}