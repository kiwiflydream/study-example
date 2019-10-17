/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.thread;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试线程的创建
 *
 * @author buhao
 * @version TestCreateThread.java, v 0.1 2019-09-24 21:37 buhao
 */
public class TestCreateThread {

    /**
     * 通过集成 Thread 实现
     */
    @Test
    public void testCreateThreadByThread() {

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }

    /**
     * 通过实现 Runable 实现
     */
    @Test
    public void testCreateThreadByRunable() {
        MyRunable myRunable = new MyRunable();

        new Thread(myRunable).start();
        new Thread(myRunable).start();

        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }

    /**
     * 通过 Runable 的 lambda 实现
     */
    @Test
    public void testCreateThreadByRunableWithLambda() {

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < 20; i++) {
                System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();

        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }

    /**
     * 通过 FutureTask 实现
     */
    @Test
    public void testCreateThreadByFutureTask() {
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new MyCallerTask());
        // 启动线程
        new Thread(futureTask).start();
        System.out.println("其它操作");
        try {
            // 等待任务执行完，并获得任务执行完的结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 FutureTask 的 lambda 实现
     */
    @Test
    public void testCreateThreadByFutureTaskWithLambda() {
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(() -> "hello");
        // 启动线程
        new Thread(futureTask).start();
        System.out.println("其它操作");
        try {
            // 等待任务执行完，并获得任务执行完的结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        String threadName = getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }
}

class MyRunable implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }
}

class MyCallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("执行任务开始");
        Thread.sleep(3000);
        System.out.println("执行任务结束");
        return "hello";
    }
}