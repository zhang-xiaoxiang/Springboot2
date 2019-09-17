package com.example.plus.exception;


import com.example.plus.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WebErrorException:统一处理页面错误,替换默认丑爆了的错误页面
 * 前后端分离,那么后台在返回页面的时候是携带数据的
 * 注意是 @RestController
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/16
 */
@RestController
@Slf4j
public class WebErrorController implements ErrorController {

    /**
     * 重定向到错误页面
     * @return
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * 错误页面(接口)拦截处理,把springboot的处理的错误路径转到自定义
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object error(HttpServletRequest request, HttpServletResponse response) {
        log.warn("response error,httpCode:" + response.getStatus());
        // 错误处理逻辑
        int status = response.getStatus();
        if (status == 404) {
            return ResultData.error(status, "页面在这个地球待不下去了,回宇宙了,再见人类");
        } else if (status >= 100 && status < 200) {
            return ResultData.error(status, "错误大体属于：服务器收到请求，需要请求者继续执行操作!");
        } else if (status >= 300 && status < 400) {
            return ResultData.error(status, "错误大体属于：重定向，需要进一步的操作以完成请求!");
        } else if (status >= 400 && status < 500) {
            return ResultData.error(status, "错误大体属于：客户端错误，请求包含语法错误或无法完成请求!");
        } else {
            return ResultData.error(500, "错误大体属于：服务器发生了错误!");
        }
    }
}
