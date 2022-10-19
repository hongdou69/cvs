package com.hongdou.cvs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: HongDou
 * @Create: 2022/10/19 22:18
 * @Description:
 */
@MapperScan(basePackages = "com.hongdou.cvs.mapper")
@SpringBootApplication
public class CvsWriteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CvsWriteApplication.class);
    }
}
