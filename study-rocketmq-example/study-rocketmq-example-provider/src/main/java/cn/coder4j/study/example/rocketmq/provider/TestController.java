/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.rocketmq.provider;

import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author buhao
 * @version TestController.java, v 0.1 2019-09-18 10:54 buhao
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/sendMsg")
    public void sendMsg(String msg) {
        Message<String> msgBody = MessageBuilder
                .withPayload(msg)
                .setHeader(MessageConst.PROPERTY_KEYS, msg)
                .build();
        rocketMQTemplate.send("TEST_MQ_TOPIC:TEST_TAG", msgBody);
    }
}