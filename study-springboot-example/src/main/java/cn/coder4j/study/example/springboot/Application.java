/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author buhao
 * @version Application.java, v 0.1 2019-11-12 14:07 buhao
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("容器开始启动");
        SpringApplication.run(Application.class, args);
        System.out.println("容器启动完毕");
    }
}