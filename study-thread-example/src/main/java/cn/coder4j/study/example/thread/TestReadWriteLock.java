/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * @author buhao
 * @version TestReadWriteLock.java, v 0.1 2020-01-28 20:28 buhao
 */
public class TestReadWriteLock {
    // 读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 读锁
    private final Lock readLock = readWriteLock.readLock();
    // 写锁
    private final Lock writeLock = readWriteLock.writeLock();
    private String key;

    public static void main(String[] args) {

        TestReadWriteLock testReadWriteLock = new TestReadWriteLock();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 无锁会出现问题
//        pool.execute(() -> System.out.println(testReadWriteLock.readOrWrite()));
//        pool.execute(() -> System.out.println(testReadWriteLock.readOrWrite()));
//        pool.execute(() -> System.out.println(testReadWriteLock.readOrWrite()));
        // 有锁时解决
        pool.execute(() -> System.out.println(testReadWriteLock.readOrWriteWithLock()));
        pool.execute(() -> System.out.println(testReadWriteLock.readOrWriteWithLock()));
        pool.execute(() -> System.out.println(testReadWriteLock.readOrWriteWithLock()));

        pool.shutdown();
    }

    public String readOrWrite() {
        if (key == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // todo: 数据库查询
            key = "val_from_db" + RandomUtil.randomNumber();
        }
        return key;
    }

    public String readOrWriteWithLock() {
        String readKey;
        readLock.lock();
        try {
            readKey = key;
        } finally {
            readLock.unlock();
        }
        if (readKey != null) {
            return readKey;
        }
        writeLock.lock();
        try {
            readKey = key;
            if (readKey == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // todo: 数据库查询
                readKey = key = "val_from_db" + RandomUtil.randomNumber();
                return readKey;
            } else {
                return readKey;
            }
        } finally {
            writeLock.unlock();
        }
    }
}