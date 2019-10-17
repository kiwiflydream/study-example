/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.thread;

/**
 * @author buhao
 * @version TestYield.java, v 0.1 2019-09-26 17:39 buhao
 */
public class TestYield {

    public static void main(String[] args) {
        Thread runnerA = new Runner();
        Thread runnerB = new Runner();

        runnerA.start();
        runnerB.start();
    }
}

class Runner extends Thread {
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 1; i <= 30; i++) {
            System.out.println(name + "跑了" + i + "步");
            if (i == 15) {
                System.out.println(name + "跑了一半了，休息一会");
                Thread.yield();
            }
        }
    }
}