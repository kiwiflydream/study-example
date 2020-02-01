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
import java.util.concurrent.atomic.LongAdder;

/**
 * @author buhao
 * @version TestLongAccumulator.java, v 0.1 2020-02-01 20:24 buhao
 */
public class TestLongAdder implements Runnable {

    private LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {
        TestLongAdder testLongAdder = new TestLongAdder();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(testLongAdder);
        pool.execute(testLongAdder);
        pool.execute(testLongAdder);
        pool.execute(testLongAdder);
        ThreadUtil.sleep(3000);
        System.out.println(testLongAdder.getLongAdder().intValue());
        pool.shutdown();
    }

    /**
     * Getter method for property <tt>longAdder</tt>.
     *
     * @return property value of longAdder
     */
    public LongAdder getLongAdder() {
        return longAdder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            longAdder.increment();
        }
    }
}