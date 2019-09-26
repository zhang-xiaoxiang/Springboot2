package com.example.plus.controller;


import com.example.plus.entity.Address;
import com.example.plus.entity.User;
import com.example.plus.result.Result;
import com.example.plus.result.ResultData;
import com.example.plus.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 收货地址列表 前端控制器
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-09-18
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AddressController {
    @Autowired
    private AddressService addressService;
    /**
     * 根据用户ID查询地址列表
     * @param address
     * @return
     */
    @GetMapping("/address")
    public Result getAddressList(@RequestBody Address address) {
        List<Address> addresses = addressService.getAddressList(address.getUserId());
        return ResultData.success("查询用户地址列表成功!", addresses);
    }
}
