package com.example.plus.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.plus.dao.AddressDao;
import com.example.plus.entity.Address;
import com.example.plus.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

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
@Autowired
private AddressDao addressDao;
    /**
     * 根据用户ID查询地址列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<Address> getAddressList(String userId) {

        List<Address> addresses=  addressDao.selectByUserId(userId);
        return addresses;
    }
}
