/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

/**
 * @author buhao
 * @version TestCount.java, v 0.1 2019-11-18 23:28 buhao
 */
public class TestCount {
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        TestCount testCount = new TestCount();
        Thread threadOne = new Thread(() -> testCount.add10k());
        Thread threadTwo = new Thread(() -> testCount.add10k());
        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(testCount.count);
    }

    public void add10k() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
}