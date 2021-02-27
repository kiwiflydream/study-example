/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author buhao
 * @version TestThreadPoolExecutor.java, v 0.1 2020-10-12 15:09 buhao
 */
public class TestThreadPoolExecutor {

    /**
     * 测试简单的线程池
     */
    @Test
    public void testSimpleThreadPoolExecutor() {

        final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                1,
                1,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2)
        );
        for (int i = 0; i < 4; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " run");
            });
        }
    }

    /**
     * 测试通过自定义工厂创建
     */
    @Test
    public void testThreadPoolExecutorWithFactory() {
        final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                1,
                4,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2),
                new ThreadFactory() {
                    private AtomicInteger threadNum = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "TEST_THREAD_POOL_" + threadNum.getAndIncrement());
                    }
                }
        );

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " run");
            });
        }
    }

    /**
     * 测试拒绝策略
     */
    @Test
    public void testThreadPoolExecutorWithRejected() {
        final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                1,
                1,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 4; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " run");
            });
        }
    }

}