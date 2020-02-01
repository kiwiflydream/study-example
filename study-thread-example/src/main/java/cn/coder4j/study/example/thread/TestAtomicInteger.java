/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author buhao
 * @version TestAtomicInteger.java, v 0.1 2020-02-01 09:20 buhao
 */
public class TestAtomicInteger implements Runnable {

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        TestAtomicInteger sum = new TestAtomicInteger();
        pool.execute(sum);
        pool.execute(sum);
        pool.execute(sum);
        pool.execute(sum);
        Thread.sleep(10000);
        System.out.println(sum.count);
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
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }
}