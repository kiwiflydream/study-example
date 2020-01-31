/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.guava;

import cn.coder4j.study.example.guava.event.UserEventListener;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * @author buhao
 * @version TestUserEventListener.java, v 0.1 2020-01-14 17:52 buhao
 */
public class TestUserEventListener {

    private static EventBus eventBus;

    @BeforeClass
    public static void init() {
//        eventBus = new EventBus();
        eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
        eventBus.register(new UserEventListener());
    }

    @Test
    public void testUserEvent() {
        eventBus.post(1);
        eventBus.post("更新用户的信息");
    }

}