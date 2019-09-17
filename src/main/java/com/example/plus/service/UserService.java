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
     * 查询用户分页
     * @param pageRequest
     * @return
     */
    PageResponse getUserPage(PageRequest pageRequest);
}
