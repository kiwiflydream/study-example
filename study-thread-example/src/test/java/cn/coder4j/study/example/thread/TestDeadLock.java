/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.thread;

/**
 * @author buhao
 * @version TestDeadLock.java, v 0.1 2019-09-26 11:51 buhao
 */
public class TestDeadLock {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "获得 lockA");
                // 暂停让下个线程更容易获得锁
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "获得 lockB");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获得 lockB");
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + "获得 lockA");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
