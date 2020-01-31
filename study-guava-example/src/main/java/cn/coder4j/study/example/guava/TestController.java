/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.guava;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author buhao
 * @version TestController.java, v 0.1 2020-01-16 15:27 buhao
 */
@RestController
public class TestController {

    @Autowired
    private EventBus eventBus;

    @GetMapping("/createUser")
    public void sendUserCreate(@RequestParam(name = "uid") Integer uid) {
        // 创建用户逻辑
        // ...........
        // 创建用户事件
        eventBus.post(uid);
    }

    @GetMapping("/updateInfo")
    public void sendUpdateUser(@RequestParam(name = "info") String info) {
        // 更新用户逻辑
        // .............
        // 更新用户事件
        eventBus.post(info);
    }
}