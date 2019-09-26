package com.example.plus.service;

import com.example.plus.entity.Address;
import com.example.plus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.plus.entity.UserDto;
import com.example.plus.page.PageRequest;
import com.example.plus.page.PageResponse;
import com.sun.javafx.collections.MappingChange;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户端用户表 服务类
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-07-04
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户ID查询用户详情
     * @param id
     * @return
     */
    User getUser(String id);

    /**
     * 根据用户ID查询用户详情--用于新的方式
     * @param id
     * @return
     */
    Map userMoreById(String id);

    /**
     * 单表条件分页
     * @param pageRequest
     * @return
     */
    PageResponse getUserPage(PageRequest pageRequest);

    /**
     * 多表条件分页(连表查询)
     * @param pageRequest
     * @return
     */
    PageResponse getUseralliancePage (PageRequest pageRequest);

    /**
     * 多表条件分页
     * 带有额为字段的封装处理
     * @param pageRequest
     * @return
     */
    PageResponse getUseralliancePage2(PageRequest pageRequest);

    /**
     * 测试直接将mybatis的结果集直接转换成json
     * @param userId
     * @return
     */
    Map getUserMap(String userId);

    /**
     * 查询用户地址(主要测试实体类封装List的处理)---常规处理
     * @param userId
     * @return
     */
    UserDto userAddressList(String userId);

    /**
     * 查询用户地址(主要测试实体类封装List的处理)---新方式
     * @param userId
     * @return
     */
    Map userAddressListNew(String userId);

    /**
     * 根据ID查询地址列表
     * @return
     */
    List<Address> getAddressList(String userId);



}
