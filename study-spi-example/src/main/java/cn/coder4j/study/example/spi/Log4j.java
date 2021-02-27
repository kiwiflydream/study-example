/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.spi;

/**
 * @author buhao
 * @version Log4j.java, v 0.1 2021-02-22 14:11 buhao
 */
public class Log4j implements Log {
    @Override
    public void info(String msg) {
        System.out.println("Log4j: " + msg);
    }
}