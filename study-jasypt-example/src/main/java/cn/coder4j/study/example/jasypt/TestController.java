/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.jasypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author buhao
 * @version TestController.java, v 0.1 2019-12-26 10:55 buhao
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${my.conf.test1}")
    private String confTest1;
    @Value("${my.conf.test2}")
    private String confTest2;

    @GetMapping("/getConf/{type}")
    @ResponseBody
    public Object getConfTest(@PathVariable Integer type) {
        if (type == 1) {
            return confTest1;
        } else {
            return confTest2;
        }
    }
}