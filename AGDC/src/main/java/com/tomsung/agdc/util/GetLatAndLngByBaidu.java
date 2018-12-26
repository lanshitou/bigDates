package com.tomsung.agdc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 获取经纬度
 *
 * @author jueyue 返回格式：Map<String,Object> map map.put("status",
 * reader.nextString());//状态 map.put("result", list);//查询结果
 * list<map<String,String>>
 * 密钥:
 */
public class GetLatAndLngByBaidu {

    /**
     * @param addr
     * 查询的地址
     * @return
     * @throws IOException
     */
    public static Object[] getCoordinate(String addr) throws IOException {
        String lng = null;//经度
        String lat = null;//纬度
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        }catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String key = "CuwxRQWY5LA8k0Rn720OOoScqyRgkqMU";
        String url = String .format("http://api.map.baidu.com/cloudgc/v1?address=%s&output=json&ak=%s", address, key);
        URL myURL = null;
        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = (URLConnection) myURL.openConnection();
            if (httpsConn != null) {
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                if((data= br.readLine())!=null){
                    //截取经纬度
                    lat = data.substring(data.indexOf("\"lat\":")+6, data.indexOf(",\"lng\":"));
                    lng = data.substring(data.indexOf("\"lng\":")+6, data.indexOf("},\"bound\":"));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(insr!=null){
                insr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new Object[]{lng,lat};
    }


    public static void main(String[] args) throws IOException {
        Object[] o = GetLatAndLngByBaidu.getCoordinate("陕西西安雁塔小寨");
        System.out.println(o[0]);//经度
        System.out.println(o[1]);//纬度
    }
}