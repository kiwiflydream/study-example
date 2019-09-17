/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.dubbo;

import cn.coder4j.study.example.dubbo.consumer.DubboConsumerBootstrap;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author buhao
 * @version BaseTest.java, v 0.1 2019-09-16 19:10 buhao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DubboConsumerBootstrap.class})
public class BaseTest {
}