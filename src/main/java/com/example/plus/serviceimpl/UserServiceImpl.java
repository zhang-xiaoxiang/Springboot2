package com.example.plus.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.plus.entity.Address;
import com.example.plus.entity.User;
import com.example.plus.dao.UserDao;
import com.example.plus.entity.UserDto;
import com.example.plus.page.MybatisResultMap;
import com.example.plus.page.PageRequest;
import com.example.plus.page.PageResponse;
import com.example.plus.result.BaseEntity;
import com.example.plus.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 根据用户ID查询用户详情---使用map方式
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
     * 根据用户ID查询用户详情--用于新的方式
     *
     * @param id
     * @return
     */
    @Override
    public Map userMoreById(String id) {
        Map userMap = userDao.userMoreById(id);
        return userMap;
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
        PageHelper.startPage(pageRequest.getPageNavigation().getPageNumber(), pageRequest.getPageNavigation().getPageSize());
        /**
         * 返回结果可以是多表联查的结果UserDto(最简单就是单表的),根据条件去数据库查询
         */
        System.out.println("=====C查数据库" + pageRequest.getPageCondition().getMap());
        List<User> userList = userDao.selectUserList(pageRequest.getPageCondition());
        System.out.println("正常长度======>" + userList);
        /**
         * 把数据库查询出来的给插件分页
         */
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        /**
         * 返回分页后的数据
         */
        return pageResponse.getResultDataVO(pageInfo);
    }

    /**
     * 用户分页带地址列表的
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageResponse getUserPage2(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNavigation().getPageNumber(), pageRequest.getPageNavigation().getPageSize());
        //查询出所有用户
        //  查询所有用户的地址
        // 组装DTO
        // 分页
        return null;
    }

    /**
     * 多表条件分页(连表查询)
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageResponse getUseralliancePage(PageRequest pageRequest) {
        Page page = PageHelper.startPage(pageRequest.getPageNavigation().getPageNumber(), pageRequest.getPageNavigation().getPageSize());
        List<Map<String, Object>> baseMap = userDao.getBaseMap(pageRequest.getPageCondition());
        List<BaseEntity> entityList = MybatisResultMap.getResultMap(baseMap);
        PageInfo<BaseEntity> pageInfo = new PageInfo<>(entityList);
        /**
         * 1:是因为在前面对PageInfo构造的时候不是分页的对象,中间经过特殊处理,那么list instanceof Page不成立,进入else if,查看源码
         * 这里直接重新赋值,把丢失的数据赋值上去
         */
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        return pageResponse.getResultDataVO(pageInfo);
    }


    /**
     * 多表条件分页
     * 带有额为字段的封装处理
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageResponse getUseralliancePage2(PageRequest pageRequest) {
        Page page = PageHelper.startPage(pageRequest.getPageNavigation().getPageNumber(), pageRequest.getPageNavigation().getPageSize());
        List<Map<String, Object>> baseMap2 = userDao.getBaseMap2(pageRequest.getPageCondition());
        List<BaseEntity> entityList = MybatisResultMap.getResultMap(baseMap2);
        PageInfo<BaseEntity> pageInfo = new PageInfo<>(entityList);
        /**
         * 1:是因为在前面对PageInfo构造的时候不是分页的对象,中间经过特殊处理,那么list instanceof Page不成立,进入else if,查看源码
         * 这里直接重新赋值,把丢失的数据赋值上去
         */
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        return pageResponse.getResultDataVO(pageInfo);
    }

    /**
     * 测试直接将mybatis的结果集直接转换成json
     *
     * @param userId
     * @return
     */
    @Override
    public Map getUserMap(String userId) {
        Map user = userDao.getUserMap(userId);


        return user;
    }

    /**
     * 查询用户地址(主要测试实体类封装List的处理)---常规处理
     *
     * @param userId
     * @return
     */
    @Override
    public UserDto userAddressList(String userId) {
        User user = userDao.selectById(userId);
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        List<Address> addressList = userDao.getAddressList(userId);
        userDto.setAddresses(addressList);
        return userDto;
    }


    /**
     * 根据ID查询地址列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<Address> getAddressList(String userId) {
        List<Address> addressList = userDao.getAddressList(userId);
        return addressList;
    }

    /**
     * 查询用户地址(主要测试实体类封装List的处理)---新方式
     *
     * @param userId
     * @return
     */
    @Override
    public Map userAddressListNew(String userId) {
        Map map = new HashMap(16);
        // map.put("user",userDao.selectById(userId));//默认查询user
        //对user封装一些字段,比如统计用户订单数的数量,地址数量
        map.put("user", userDao.userMoreById(userId));
        map.put("address", userDao.getAddressList(userId));
        //下面可以封装订单等等....和上面类似
        return map;
    }
}
