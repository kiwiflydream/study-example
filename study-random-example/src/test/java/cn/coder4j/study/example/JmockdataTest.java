/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example;

import cn.coder4j.study.example.random.Person;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * jmockdata 测试
 *
 * @author buhao
 * @version JmockdataTest.java, v 0.1 2020-04-19 18:33 buhao
 */
public class JmockdataTest {

    @Test
    public void testBaseType() {
        // 基础数据类型
        System.out.println(JMockData.mock(byte.class));
        System.out.println(JMockData.mock(int.class));
        System.out.println(JMockData.mock(long.class));
        System.out.println(JMockData.mock(double.class));
        System.out.println(JMockData.mock(float.class));
        System.out.println(JMockData.mock(String.class));
        System.out.println(JMockData.mock(BigDecimal.class));

        // 基础数据类型的数组
        System.out.println(JMockData.mock(byte[].class));
        System.out.println(JMockData.mock(int[].class));
        System.out.println(JMockData.mock(long[].class));
        System.out.println(JMockData.mock(double[].class));
        System.out.println(JMockData.mock(float[].class));
        System.out.println(JMockData.mock(String[].class));
        System.out.println(JMockData.mock(BigDecimal[].class));
    }

    /**
     * java bean 测试
     */
    @Test
    public void testJavaBean() {
        Person mock = JMockData.mock(Person.class);
        System.out.println(mock);
    }

    @Test
    public void testJavaBeanWithConfig() {

        MockConfig mockConfig =
                new MockConfig()
                        .subConfig("age")
                        // 设置 int 的范围
                        .intRange(1, 100)
                        .subConfig("email")
                        // 设置生成邮箱正则
                        .stringRegex("[a-z0-9]{5,15}\\@\\w{3,5}\\.[a-z]{2,3}")
                        .globalConfig();

        Person mock = JMockData.mock(Person.class, mockConfig);
        System.out.println(mock);
    }
}