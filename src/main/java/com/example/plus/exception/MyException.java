package com.example.plus.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * MyException:自定义异常类
 *
 * @author zhangxiaoxiang
 * @date: 2019/06/26
 */
@Data
public class MyException extends RuntimeException implements Serializable {
    /**
     * 自定义异常获取到的信息
     */
    private String message;

    public MyException(String message) {
        this.message = message;
    }
}
