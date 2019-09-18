package com.example.plus.page;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * PageCondition:数据库分页条件
 * 注意值最好加上引号,比如性别为  "userSex":"0" 这个条件就必须添加""
 * @author zhangxiaoxiang
 * @date 2019/9/15
 */
@Data
@Component
public class PageCondition {
    /**
     * 分页条件直接获取前端的json转换成map,所有业务的条件都可以使用它(查询用户,订单,粉丝...各种条件的map集合)
     */
    private Map<String,Object> map;


}
