/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tio.core.Tio;
import org.tio.websocket.common.WsResponse;
import org.tio.websocket.starter.TioWebSocketServerBootstrap;

/**
 * @author buhao
 * @version TestController.java, v 0.1 2019-10-21 15:30 buhao
 */
@Controller
@RequestMapping
public class TestController {

    @Autowired
    private TioWebSocketServerBootstrap bootstrap;

    @GetMapping("/send")
    public @ResponseBody
    Object sendMsg(String msg) {
        Tio.sendToAll(bootstrap.getServerTioConfig(), WsResponse.fromText(msg, "utf-8"));
        return "success";
    }
}