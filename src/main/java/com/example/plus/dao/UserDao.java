package com.example.plus.dao;

import com.example.plus.entity.Address;
import com.example.plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.plus.entity.UserDto;
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
    //这里面有丰富的查询方法,自定义的也可以写在这里

    /**
     * 分页条件查询数据库
     *
     * @param pageCondition
     * @return
     */
    List<User> selectUserList(PageCondition pageCondition);


    /**
     * 用户列表带地址集合的(常规方式)
     * @param pageCondition
     * @return
     */
    List<UserDto> selectUserList2(PageCondition pageCondition);

    /**
     * 使用map处理分页的 用户信息带地址列表地址
     * @param pageCondition
     * @return
     */
    List<Map<String,Object>> selectUserList3(PageCondition pageCondition);


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
    Map getUserMap(String userId);
    /**
     * 查询用户地址(主要测试实体类封装List的处理)
     *
     * @param userId
     * @return
     */
    UserDto userAddressList(String userId);

    /**
     * 根据用户ID查询地址列表
     * @param userId
     * @return
     */
    List<Address> getAddressList(String userId);

    /**
     * 查询添加过字段的单表
     * @param id
     * @return
     */
    Map userMoreById(String id);


}
