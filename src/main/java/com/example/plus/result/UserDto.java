package com.example.plus.result;

import com.example.plus.entity.Address;

import java.util.List;

public class UserDto<T> {
    private T t;
    private List<Address> list;
}
