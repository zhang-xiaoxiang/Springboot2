package com.example.plus.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * PageInitialize:请求分页初始化,解析分页需求
 *
 * @author zhangxiaoxiang
 * @date: 2019/09/15
 */
@Data
@Slf4j
public class PageInitialize {
    /**
     * 分页初始化
     *
     * @param pageCondition 入参转换为map,并组装到分页请求的类中,本质就是json转map
     * @return
     */
    public static PageCondition getPageInitializeUtil(PageCondition pageCondition) {
        try {
            String pageConditionStr = JSON.toJSONString(pageCondition);
            Map<String, Object> map = new HashMap<>();
            JSONObject pageObject = JSONObject.parseObject(pageConditionStr);
            for (Map.Entry<String, Object> entry : pageObject.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                map.put(entry.getKey(), entry.getValue());
            }
            pageCondition.setMap(map);

            return pageCondition;

        } catch (Exception e) {
            log.error("分页初始化错误,请检查参数" + e.getMessage());
            return null;
        }


    }
}
