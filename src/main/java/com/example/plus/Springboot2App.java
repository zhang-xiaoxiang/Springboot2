package com.example.plus;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * MpPlusApplication:集成mybatis plus 单表条件分页 基本项目初始化
 *
 * @author zhangxiaoxiang
 * @date 2019/7/2
 */

@Slf4j
//扫描dao层(也叫Mapper接口层,一个意思)
@MapperScan("com.example.plus.dao")
@SpringBootApplication
public class Springboot2App {
    public static void main(String[] args) {
        SpringApplication.run(Springboot2App.class, args);
        log.info("mybatis-plus 入门,官方文档");
        System.out.println("https://mp.baomidou.com/");
        System.out.println("根据用户ID查询  http://localhost:8080/user/get");
        System.out.println("根据用户ID查询  http://localhost:8080/user/info/00");
        System.out.println("单表条件分页  http://localhost:8080/user/page/single-table");
    }

}
