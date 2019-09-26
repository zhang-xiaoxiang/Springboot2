package com.example.plus.controller;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.example.plus.entity.User;
import com.example.plus.exception.MyException;
import com.example.plus.page.PageCondition;
import com.example.plus.page.PageRequest;
import com.example.plus.page.PageResponse;
import com.example.plus.result.Result;
import com.example.plus.result.ResultData;
import com.example.plus.service.UserService;
import com.example.plus.page.PageInitialize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;


/**
 * <p>
 * 客户端用户表 前端控制器
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-07-04
 */
@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PageCondition pageCondition;

    @RequestMapping("/get")
    public Object getUser(@RequestBody User user){
        log.info("注意入参是json格式的才行: "+user.getUserId());
       return  userService.getUser(user.getUserId());
    }


    /**
     * REST风格
     *
     * @param userid
     * @return
     */
    @GetMapping("/info/{userid}")
    public Object getUser(@PathVariable("userid") String userid) {
        log.info("这种REST风格可以直接在接口传参数 ");
        //模拟异常
        // int i=1/0;
        // throw new MyException("自定义异常哈!");
         return userService.getUser(userid);
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
        return  ResultData.success("查询用户信心成功!",pageResponse);

    }

    @GetMapping("/page/multi-extra")
    public Result getUserPage3(@RequestBody PageRequest pageRequest) {
        /**
         * 分页请求还原json格式(@RequestBody把json转成了java对象,所以为了需要就还原一下)
         */
        PageCondition condition = PageInitialize.getPageInitializeUtil(pageRequest.getPageCondition());
        log.info("查询条件condition===>" + condition);
        PageResponse pageResponse = userService.getUseralliancePage2(pageRequest);
        return  ResultData.success("查询用户信心成功!",pageResponse);

    }

    /**
     * 测试直接将mybatis的结果集直接转换成json
      * @param user
     * @return
     */
    @GetMapping("/get-usermap")
    public Result getUserMap(@RequestBody User user){
      User user1=  userService.getUserMap(user.getUserId() );

        return ResultData.success("查询成功!",user1);

    }


}
