/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */

package cn.coder4j.study.example.guava;

import cn.coder4j.study.example.guava.event.BaseEventListener;
import com.google.common.eventbus.EventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EventBus eventBus(List<BaseEventListener> listenerList) {
        // 创建同步事件总线
        EventBus eventBus = new EventBus();
        // 把订阅类全部注册到事件总线上
        listenerList.forEach(eventBus::register);
        return eventBus;
    }
}
