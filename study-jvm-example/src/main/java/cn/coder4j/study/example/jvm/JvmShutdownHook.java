/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.jvm;

/**
 * @author buhao
 * @version JvmShutdownHook.java, v 0.1 2019-11-13 19:22 buhao
 */
public class JvmShutdownHook {

    public static void main(String[] args) {
        // 注册 shutdown hook


        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("jvm shutdown hook run")));

        System.out.println("项目启动");
        try {
            Thread.sleep(99999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}