package com.xlearn.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:程序启动入口
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xlearn.sell.dao")
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }

}
