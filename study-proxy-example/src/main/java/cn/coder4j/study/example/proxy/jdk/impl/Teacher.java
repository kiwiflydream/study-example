/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.proxy.jdk.impl;

import cn.coder4j.study.example.proxy.jdk.Person;

/**
 * @author buhao
 * @version Teacher.java, v 0.1 2020-10-14 15:14 buhao
 */
public class Teacher implements Person {
    /**
     * 工作
     */
    @Override
    public void work() {
        System.out.println("教书");
    }
}