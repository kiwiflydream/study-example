/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.proxy.jdk;

import cn.coder4j.study.example.proxy.jdk.impl.Student;

/**
 * @author buhao
 * @version TestJdkProxy.java, v 0.1 2020-10-14 15:31 buhao
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        final Student target = new Student();
        final Person person = (Person) new JdkProxy(target).newInstance();
        person.work();
    }
}