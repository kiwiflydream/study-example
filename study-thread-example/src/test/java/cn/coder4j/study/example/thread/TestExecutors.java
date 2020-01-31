/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author buhao
 * @version TestExecutors.java, v 0.1 2020-01-31 20:35 buhao
 */
public class TestExecutors {

    /**
     * 测试缓存线程池
     */
    @Test
    public void testNewCachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
    }

    /**
     * 测试固定线程池
     */
    @Test
    public void testNewFixedThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
    }


    /**
     * 创建单个线程
     */
    @Test
    public void testNewSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " run"));
    }

    /**
     * 创建调度的线程池
     */
    @Test
    public void testNewScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        // 延迟执行
//        scheduledThreadPool.schedule(() -> System.out.println(Thread.currentThread().getName() + " run,at " + new Date().toString()), 3, TimeUnit.SECONDS);
        // 定期执行
        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName() + " run,at " + new Date().toString()), 0, 3, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }
}