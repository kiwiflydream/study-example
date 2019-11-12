/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.springboot;

import cn.coder4j.study.example.springboot.loadorder.BaseFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author buhao
 * @version TestOrder.java, v 0.1 2019-11-12 21:15 buhao
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestOrder {

    @Autowired
    private List<BaseFilter> filters;

    @Test
    public void testLoadOrder() {
        for (BaseFilter filter : filters) {
            System.out.println(filter.getClass().getSimpleName());
        }
    }
}