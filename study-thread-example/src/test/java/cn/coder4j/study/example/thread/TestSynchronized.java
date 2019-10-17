/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.thread;

/**
 * @author buhao
 * @version TestSynchronized.java, v 0.1 2019-09-27 17:01 buhao
 */
public class TestSynchronized {
    private int num = 0;

    public static void main(String[] args) {
        TestSynchronized resources = new TestSynchronized();
        Runnable runnable = () -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " - " + resources.num++);
            }
        };
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
    }
}
