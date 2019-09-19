/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */

package cn.coder4j.study.example.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 *
 */
@SpringBootApplication
public class StudyRocketmqExampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRocketmqExampleConsumerApplication.class, args);
    }

    @Service
    @RocketMQMessageListener(topic = "TEST_MQ_TOPIC", consumerGroup = "TEST_MQ_GROUP")
    public class MyConsumer1 implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            System.out.println(message);
        }
    }
}
