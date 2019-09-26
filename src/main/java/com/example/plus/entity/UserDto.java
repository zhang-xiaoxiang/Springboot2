package com.example.plus.entity;

import lombok.Data;

import java.util.List;

/**
 * UserDto:用户详情
 * @author zhangxiaoxiang
 * @date 2019/9/26
 */
@Data
public class UserDto {
    private User user;
    private List<Address> addresses;
}
