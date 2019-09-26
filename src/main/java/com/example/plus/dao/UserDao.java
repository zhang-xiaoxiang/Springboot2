package com.example.plus.dao;

import com.example.plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.plus.page.PageCondition;
import com.example.plus.result.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户端用户表 Mapper 接口
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-07-04
 */
public interface UserDao extends BaseMapper<User> {
    /**
     * 分页条件查询数据库
     *
     * @param pageCondition
     * @return
     */
    List<User> selectUserList(PageCondition pageCondition);
//这里面有丰富的查询方法,自定义的也可以写在这里

    // List<Map<String,Object>> getBaseMap(PageCondition pageCondition);
    List<Map<String, Object>> getBaseMap(PageCondition pageCondition);

    /**
     * 含有额为字段的结果映射
     *
     * @param pageCondition
     * @return
     */
    List<Map<String, Object>> getBaseMap2(PageCondition pageCondition);
    /**
     * 测试直接将mybatis的结果集直接转换成json
     *
     * @param userId
     * @return
     */
    User getUserMap(String userId);
}
