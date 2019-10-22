/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */

package cn.coder4j.study.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StudyWebsocketExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyWebsocketExampleApplication.class, args);
    }

    /**
     * 使用 map 当简易缓存用
     *
     * @return
     */
    @Bean
    public Map<String, WebSocketSession> onlineUserCache() {
        return new HashMap<>();
    }
}
