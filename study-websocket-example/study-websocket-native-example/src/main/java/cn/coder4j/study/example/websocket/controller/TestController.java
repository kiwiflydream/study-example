/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.websocket.controller;

import cn.coder4j.study.example.websocket.config.WsSessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @author buhao
 * @version TestController.java, v 0.1 2019-10-17 20:20 buhao
 */
@Controller
public class TestController {

    @RequestMapping("/sendMsg")
    public @ResponseBody
    Object sendMsg(String token, String msg) throws IOException {
        WebSocketSession webSocketSession = WsSessionManager.get(token);
        if (webSocketSession == null) {
            return "用户登录已失效";
        }
        webSocketSession.sendMessage(new TextMessage(msg));
        return "消息发送成功";
    }
}