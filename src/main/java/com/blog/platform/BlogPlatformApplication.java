package com.blog.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@SpringBootApplication
@MapperScan(basePackages = "com.blog.platform.mapper")
public class BlogPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogPlatformApplication.class, args);
    }

}
