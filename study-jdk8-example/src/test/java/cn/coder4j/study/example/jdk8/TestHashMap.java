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

import java.util.HashMap;

/**
 * @author buhao
 * @version StudyHashMap.java, v 0.1 2020-03-04 22:00 buhao
 */
public class TestHashMap {

    @Test
    public void testDefaultInitSize() {
//        System.out.println(1 >> 2);
//        System.out.println(1 << 4);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.toBinaryString(-5));
//        System.out.println(new BigDecimal(Math.pow(2, 31)));
//        System.out.println(0b1111);
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(~4));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

    }

    @Test
    public void testSetCap() {
        final HashMap<Object, Object> map = new HashMap<>(1);
        map.put("1", "1");
        map.put("2", "2");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            map.put(i, i);
        }

        System.out.println(map);
    }
}