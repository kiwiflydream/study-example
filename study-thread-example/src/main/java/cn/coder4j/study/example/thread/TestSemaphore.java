/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.concurrent.Semaphore;

/**
 * @author buhao
 * @version TestSemaphore.java, v 0.1 2020-01-28 19:23 buhao
 */
public class TestSemaphore {
    // 初始化值为 2 的信号灯
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        TestSemaphore testSemaphore = new TestSemaphore();
        Thread thread1 = new Thread(() -> testSemaphore.run());
        Thread thread2 = new Thread(() -> testSemaphore.run());
        Thread thread3 = new Thread(() -> testSemaphore.run());
        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}