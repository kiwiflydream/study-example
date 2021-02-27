/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author buhao
 * @version TestSimpleReentrant.java, v 0.1 2020-10-13 14:14 buhao
 */
public class TestSimpleReentrant {

    private Integer total = 0;
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        final TestSimpleReentrant testSimpleReentrant = new TestSimpleReentrant();

        final Thread thread1 = new Thread(() -> testSimpleReentrant.add10k());
        final Thread thread2 = new Thread(() -> testSimpleReentrant.add10k());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(testSimpleReentrant.getTotal());
    }

    public void add10k() {
        try {
            lock.lock();
            for (int i = 0; i < 10000; i++) {
                total++;
            }
        } finally {
            lock.unlock();
        }

    }

    /**
     * Getter method for property <tt>total</tt>.
     *
     * @return property value of total
     */
    public Integer getTotal() {
        return total;
    }
}