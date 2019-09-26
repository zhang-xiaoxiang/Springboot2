package com.example.plus.service;

import com.example.plus.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 收货地址列表 服务类
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-09-18
 */
public interface AddressService extends IService<Address> {
    /**
     * 根据用户ID查询地址列表
     * @param userId
     * @return
     */
    List<Address> getAddressList(String userId);
}
