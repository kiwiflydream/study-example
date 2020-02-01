/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author buhao
 * @version TestCompletableFuture.java, v 0.1 2020-01-31 22:05 buhao
 */
public class TestCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println(getThreadName() + " 洗水壶");
            System.out.println(getThreadName() + " 烧开水");
        });
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            System.out.println(getThreadName() + " 洗茶壶");
            System.out.println(getThreadName() + " 洗茶杯");
            System.out.println(getThreadName() + " 拿茶叶");
        });
        f1.runAfterBoth(f2, () -> System.out.println(getThreadName() + " 烧茶"));
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }
}