package com.example.plus.service;

import com.example.plus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.plus.page.PageRequest;
import com.example.plus.page.PageResponse;

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
    User getUserMap(String userId);
}
