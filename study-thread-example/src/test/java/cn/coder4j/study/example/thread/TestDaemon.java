/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.thread;

/**
 * @author buhao
 * @version TestDaemon.java, v 0.1 2019-09-26 15:47 buhao
 */
public class TestDaemon {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
            }
        });
//        thread.setDaemon(true);
        thread.start();
    }
}