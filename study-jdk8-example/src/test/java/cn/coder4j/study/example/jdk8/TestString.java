/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.jdk8;

import org.junit.Test;

/**
 * 测试字符串
 *
 * @author buhao
 * @version TestString.java, v 0.1 2020-09-29 12:07 buhao
 * @date 2020/09/29
 */
public class TestString {

    @Test
    public void testStr() {
        final String s1 = new String("kkkwww");
        final String s2 = "kkkwww";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println("");
    }

}