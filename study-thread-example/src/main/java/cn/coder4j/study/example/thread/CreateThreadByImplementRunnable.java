/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.Date;

/**
 * @author buhao
 * @version CreateThreadByImplementRunnable.java, v 0.1 2021-01-30 10:48 buhao
 */
public class CreateThreadByImplementRunnable implements Runnable {
    public static void main(String[] args) {
        final CreateThreadByImplementRunnable createThreadByImplementRunnable = new CreateThreadByImplementRunnable();

        new Thread(createThreadByImplementRunnable).start();
        new Thread(createThreadByImplementRunnable).start();

        final String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        final String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }
}