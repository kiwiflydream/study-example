/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.guava.event;

import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Service;

/**
 * @author buhao
 * @version UserEventListener.java, v 0.1 2020-01-14 17:48 buhao
 */
@Service
public class UserEventListener implements BaseEventListener {

    @Subscribe
    public void create(Integer userId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("创建: userId = " + userId);
    }

    @Subscribe
    public void update(String info) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("修改：info = " + info);
    }
}