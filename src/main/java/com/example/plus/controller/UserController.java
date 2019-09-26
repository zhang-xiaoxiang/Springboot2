package com.example.plus.controller;


import com.example.plus.entity.Address;
import com.example.plus.entity.User;
import com.example.plus.entity.UserDto;
import com.example.plus.page.PageCondition;
import com.example.plus.page.PageRequest;
import com.example.plus.page.PageResponse;
import com.example.plus.result.Result;
import com.example.plus.result.ResultData;
import com.example.plus.service.UserService;
import com.example.plus.page.PageInitialize;
import com.example.plus.util.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 客户端用户表 前端控制器
 *
 * @author zhangxiaoxiang
 * @since 2019-07-04
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    //条件分页辅助
    @Autowired
    private PageCondition pageCondition;


    /**
     * REST风格  根据Id查询用户
     *
     * @param userid
     * @return
     */
    @GetMapping("/user/{userid}")
    public Result getUser(@PathVariable("userid") String userid) {
        return ResultData.success("REST风格 根据id查询用户成功!", userService.getUser(userid));
    }
    // ------------------------------------------REST风格--------------------------------------
    // 增PostMapping 删 @DeleteMapping 改 @PutMapping 查 GetMapping 传参使用json @RequestBody或者 路径参数 @PathVariable()
    // 代替?name=zhangsan的URL形式

    /**
     * 根据Id查询用户 json格式 REST风格
     *
     * @param user
     * @return
     */
    @GetMapping("/user")
    public Result getUser(@RequestBody User user) {
        //这里不用处理异常,有全局拦截异常的
        return ResultData.success("根据id查询用户成功!", userService.getUser(user.getUserId()));
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public Result add(@RequestBody User user) {
        //这里写业务代码是因为我要使用 数据库提供的通用方法,
        // 不用写dao,xml,service以及实现类impl,所以这里还是会涉及到一定的业务逻辑代码
        //优点:方便快捷,缺点:不好定位错误原因
        user.setUserId(IdWorker.getSimpleId());
        user.setCreateTime(new Date());
        user.setUserDateBirth(new Date());
        return ResultData.conditions(userService.save(user));
    }

    /**
     * 根据ID修改用户
     *
     * @param user
     * @return
     */
    @PutMapping("/user")
    public Result upd(@RequestBody User user) {
        if (user.getUserId() == null) {
            return ResultData.error("用户ID不存在!");
        }
        return ResultData.conditions(userService.updateById(user));
    }

    /**
     * 根据ID删除用户
     * @param user
     * @return
     */
    @DeleteMapping("/user")
    public Result del(@RequestBody User user) {
        return ResultData.conditions(userService.removeById(user.getUserId()));
    }


    @GetMapping("/page/single-table")
    public Result getUserPage(@RequestBody PageRequest pageRequest) {
        /**
         * 分页请求还原json格式(@RequestBody把json转成了java对象,所以为了需要就还原一下)
         */
        PageCondition condition = PageInitialize.getPageInitializeUtil(pageRequest.getPageCondition());
        log.info("查询条件condition===>" + condition);
        PageResponse pageResponse = userService.getUserPage(pageRequest);
        Result result = ResultData.success("查询用户信心成功!", pageResponse);
        return result;

    }

    @GetMapping("/page/multi-table")
    public Result getUserPage2(@RequestBody PageRequest pageRequest) {
        /**
         * 分页请求还原json格式(@RequestBody把json转成了java对象,所以为了需要就还原一下)
         */
        PageCondition condition = PageInitialize.getPageInitializeUtil(pageRequest.getPageCondition());
        log.info("查询条件condition===>" + condition);
        PageResponse pageResponse = userService.getUseralliancePage(pageRequest);
        return ResultData.success("查询用户信心成功!", pageResponse);

    }

    @GetMapping("/page/multi-extra")
    public Result getUserPage3(@RequestBody PageRequest pageRequest) {
        /**
         * 分页请求还原json格式(@RequestBody把json转成了java对象,所以为了需要就还原一下)
         */
        PageCondition condition = PageInitialize.getPageInitializeUtil(pageRequest.getPageCondition());
        log.info("查询条件condition===>" + condition);
        PageResponse pageResponse = userService.getUseralliancePage2(pageRequest);
        return ResultData.success("查询用户信心成功!", pageResponse);

    }

    /**
     * 测试直接将mybatis的结果集直接转换成json
     *
     * @param user
     * @return
     */
    @GetMapping("/get-usermap")
    public Result getUserMap(@RequestBody User user) {
        Map map = userService.getUserMap(user.getUserId());

        return ResultData.success("查询成功!", map);

    }

    /**
     * 查询用户地址(主要测试实体类封装List的处理)
     *
     * @param user
     * @return
     */
    @GetMapping("/user-address-list")
    public Result userAddressList(@RequestBody User user) {
        UserDto userDto = userService.userAddressList(user.getUserId());
        return ResultData.success("查询用户地址成功!", userDto);
    }


    /**
     * 查询用户地址(主要测试实体类封装List的处理)----新的方式
     *
     * @param user
     * @return
     */
    @GetMapping("/user-address-list-new")
    public Result userAddressListNew(@RequestBody User user) {
        Map map = userService.userAddressListNew(user.getUserId());
        return ResultData.success("查询用户地址成功!", map);
    }

    @GetMapping("/get-address-list")
    public Result getAddressList(@RequestBody User user) {
        List<Address> addresses = userService.getAddressList(user.getUserId());
        return ResultData.success("查询用户地址列表成功!", addresses);
    }

}
