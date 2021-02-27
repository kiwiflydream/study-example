/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.jdk8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author buhao
 * @version TestQueue.java, v 0.1 2020-10-20 19:56 buhao
 */
public class TestQueue {

    private static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        producer();
        consumer();
    }


    /**
     * 生产者
     */
    public static void producer() {
        queue.add("a");
        queue.add("b");
        queue.add("c");
    }


    /**
     * 消费者
     */
    public static void consumer() {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }


}