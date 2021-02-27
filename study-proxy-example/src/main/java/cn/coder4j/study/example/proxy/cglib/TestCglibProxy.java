/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.proxy.cglib;

import cn.coder4j.study.example.proxy.jdk.Person;
import cn.coder4j.study.example.proxy.jdk.impl.Student;

/**
 * @author buhao
 * @version TestCglibProxy.java, v 0.1 2020-10-14 17:11 buhao
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        final Student target = new Student();
        final Person proxy = (Person) new CglibProxy(target).getInstance();
        proxy.work();
    }
}