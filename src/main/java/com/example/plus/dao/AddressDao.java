package com.example.plus.dao;

import com.example.plus.entity.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 收货地址列表 Mapper 接口
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-09-18
 */
public interface AddressDao extends BaseMapper<Address> {
    /**
     * 根据用户ID查询收货地址列表
     * @param userId
     * @return
     */
    @Select("select * from address where user_id=#{userId}")
    List<Address> selectByUserId(@Param("userId") String userId);
}
