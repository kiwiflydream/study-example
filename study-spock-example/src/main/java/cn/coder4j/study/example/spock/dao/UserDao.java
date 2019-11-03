/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.spock.dao;

import cn.coder4j.study.example.spock.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buhao
 * @version UserDao.java, v 0.1 2019-10-30 16:24 buhao
 */
@Component
public class UserDao {

    /**
     * 模拟数据库
     */
    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("k", new User("k", 1, "123"));
        userMap.put("i", new User("i", 2, "456"));
        userMap.put("w", new User("w", 3, "789"));
    }

    /**
     * 通过用户名查询用户
     *
     * @param name
     * @return
     */
    public User findByName(String name) {
        return userMap.get(name);
    }
}