package com.example.plus.serviceimpl;

import com.example.plus.dao.AddressDao;
import com.example.plus.entity.Address;
import com.example.plus.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货地址列表 服务实现类
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-09-18
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressDao, Address> implements AddressService {

}
