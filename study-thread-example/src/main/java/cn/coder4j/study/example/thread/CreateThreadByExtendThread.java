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
 * @version CreateThreadByExtendThread.java, v 0.1 2021-01-30 09:51 buhao
 */
public class CreateThreadByExtendThread extends Thread {
    public static void main(String[] args) {
        final CreateThreadByExtendThread thread1 = new CreateThreadByExtendThread();
        final CreateThreadByExtendThread thread2 = new CreateThreadByExtendThread();

        thread1.start();
        thread2.start();

        final String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }

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
        // 获得线程名称
        final String threadName = getName();

        for (int i = 0; i < 20; i++) {
            System.out.println("线程[" + threadName + "]运行开始,i = " + i + " time = " + new Date());
        }
    }
}