/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.thread;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author buhao
 * @version TestNotifyAndWait.java, v 0.1 2019-09-25 14:24 buhao
 */
public class TestNotifyAndWait {

    public static void main(String[] args) {
        LinkedList<Integer> goods = new LinkedList<>();

        Thread producer = new Thread(new Producer(goods));
        Thread consumer = new Thread(new Consumer(goods));

        producer.start();
        consumer.start();
    }
}

class Consumer implements Runnable {

    private LinkedList<Integer> goods;

    public Consumer(LinkedList<Integer> goods) {
        this.goods = goods;
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
        while (true) {
            synchronized (this.goods) {
                while (this.goods.size() <= 0) {
                    try {
                        System.out.println("消费等待");
                        this.goods.notify();
                        this.goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.goods.removeFirst();
                System.out.println("消费");

            }
        }
    }
}

class Producer implements Runnable {

    private LinkedList<Integer> goods;

    public Producer(LinkedList<Integer> goods) {
        this.goods = goods;
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
        while (true) {
            synchronized (this.goods) {

                while (this.goods.size() >= 1) {
                    System.out.println("生产等待");
                    this.goods.notify();
                    try {
                        this.goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                this.goods.addFirst(new Random().nextInt());
                System.out.println("生产");

            }
        }
    }
}