/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author buhao
 * @version TestAtomicLong.java, v 0.1 2020-02-01 17:59 buhao
 */
public class TestAtomicLong implements Runnable {

    private AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        TestAtomicLong testAtomicLong = new TestAtomicLong();
        pool.execute(testAtomicLong);
        pool.execute(testAtomicLong);
        pool.execute(testAtomicLong);
        ThreadUtil.sleep(5000);
        System.out.println(testAtomicLong.atomicLong);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            long val;
            long newVal;
            do {
                val = atomicLong.get();
                newVal = val + 1;
            } while (!atomicLong.compareAndSet(val, newVal));
        }
    }
}