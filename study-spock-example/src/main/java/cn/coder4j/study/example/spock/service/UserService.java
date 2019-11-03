/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.spock.service;

import cn.coder4j.study.example.spock.dao.UserDao;
import cn.coder4j.study.example.spock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author buhao
 * @version UserService.java, v 0.1 2019-10-30 16:29 buhao
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public void loginAfter() {
        System.out.println("登录成功");
    }

    public void login(String name, String passwd) {
        User user = findByName(name);
        if (user == null) {
            throw new RuntimeException(name + "不存在");
        }
        if (!user.getPasswd().equals(passwd)) {
            throw new RuntimeException(name + "密码输入错误");
        }
        loginAfter();
    }
}