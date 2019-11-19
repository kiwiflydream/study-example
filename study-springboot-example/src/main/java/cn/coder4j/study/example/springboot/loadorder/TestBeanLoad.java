/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.springboot.loadorder;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @author buhao
 * @version TestBeanLoad.java, v 0.1 2019-11-12 14:08 buhao
 */
@Configuration
public class TestBeanLoad {

    @Bean
    @Order
    public DefaultOrder defaultOrder() {
        System.out.println("defaultOrder 加载");
        return new DefaultOrder();
    }

    @Bean
    public NoOrder noOrder() {
        System.out.println("noOrder 加载");
        return new NoOrder();
    }

    @Bean
    @Order(2)
    public TwoOrder twoOrder() {
        System.out.println("twoOrder 加载");
        return new TwoOrder();
    }

    @Bean
    @Order(1)
    public OneOrder oneOrder() {
        System.out.println("oneOrder 加载");
        return new OneOrder();
    }


    @Bean
    @Order(3)
    @DependsOn("dependsOnTarget")
    public DependsOnFrom dependsOnFrom() {
        System.out.println("dependsOnFrom 加载");
        return new DependsOnFrom();
    }

    @Bean
    @Order(4)
    public DependsOnTarget dependsOnTarget() {
        System.out.println("dependsOnTarget 加载");
        return new DependsOnTarget();
    }

    @Bean
    public MyCommandLineRunner myCommandLineRunner() {
        return new MyCommandLineRunner();
    }

    @Bean
    public MyApplicationRunner myApplicationRunner() {
        return new MyApplicationRunner();
    }
}

class OneOrder {
    public OneOrder() {
        System.out.println(this.getClass().getSimpleName() + "初始化");
    }
}

class TwoOrder {
    public TwoOrder() {
        System.out.println(this.getClass().getSimpleName() + "初始化");
    }
}

class NoOrder {
    public NoOrder() {
        System.out.println(this.getClass().getSimpleName() + "初始化");
    }
}

class DefaultOrder {
    public DefaultOrder() {
        System.out.println(this.getClass().getSimpleName() + "初始化");
    }
}

class DependsOnFrom {
    public DependsOnFrom() {
        System.out.println(this.getClass().getSimpleName() + "初始化");
    }
}

class DependsOnTarget {
    public DependsOnTarget() {
        System.out.println(this.getClass().getSimpleName() + "初始化");
    }
}

class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner 执行，" + args.getOptionValues("env"));
    }
}

class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner 执行， " + Arrays.asList(args));
    }
}