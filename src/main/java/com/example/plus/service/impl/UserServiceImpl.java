package com.example.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.plus.entity.User;
import com.example.plus.mapper.UserDao;
import com.example.plus.page.PageNavigation;
import com.example.plus.page.PageRequest;
import com.example.plus.page.PageResponse;
import com.example.plus.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 客户端用户表 服务实现类
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-07-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PageResponse pageResponse;

    /**
     * 根据用户ID查询用户详情
     *
     * @param id
     * @return
     */
    @Override
    public User getUser(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", id);
        User user = userDao.selectById(id);
        System.out.println(user);
        return user;
    }

    /**
     * 查询用户分页
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageResponse getUserPage(PageRequest pageRequest) {
        /**
         * 分页辅助类,起始页和每页大小
         */

        PageHelper.startPage(pageRequest.getPageNavigation().getPageNum(), pageRequest.getPageNavigation().getPageSize());
        /**
         * 返回结果可以是多表联查的结果UserDto(最简单就是单表的),根据条件去数据库查询
         */
        System.out.println("=====C查数据库"+pageRequest.getPageCondition().getMap());
        List<User> userList = userDao.selectUserList(pageRequest.getPageCondition());
        /**
         * 把数据库查询出来的给插件分页
         */
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        /**
         * 返回分页后的数据
         */
        return pageResponse.getResultDataVO(pageInfo);
    }
}
