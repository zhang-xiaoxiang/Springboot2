package com.example.plus;

import com.example.plus.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2AppTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        // Map<String, String> baseMap = new LinkedHashMap<>();
        // List<Map<String, Object>> baseList = userDao.getBaseMap();
        // System.out.println(baseList);
        // for (Map<String, Object> map : baseList     //遍历list
        // ) {
        //     String base = null;
        //     String fare = null;
        //     for (Map.Entry<String, Object> entry : map.entrySet()   //遍历map的key集合 获取对应key的value
        //     ) {
        //         System.out.println("map的键值对:"+map.entrySet());
        //         // System.out.println(entry.getKey());
        //         // if ("userName".equals(entry.getKey())) {
        //         //     base = String.valueOf(entry.getValue());
        //         // }
        //         // if ("addressRegion".equals(entry.getKey())) {
        //         //     fare =String.valueOf(entry.getValue());
        //         // }
        //         baseMap.put(entry.getKey(),String.valueOf(entry.getValue()));
        //     }
        // }
        // System.out.println(baseMap);
    }

}
