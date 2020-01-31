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
import java.util.concurrent.locks.StampedLock;

/**
 * @author buhao
 * @version TestStampedLock.java, v 0.1 2020-01-29 10:58 buhao
 */
public class TestStampedLock {
    // 读写锁
    private final StampedLock stampedLock = new StampedLock();
    private String key;

    public static void main(String[] args) {

        TestStampedLock testReadWriteLock = new TestStampedLock();

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
        String readKey = null;
        long rl = stampedLock.tryOptimisticRead();
        // 如果已经修改，就升级成悲观读
        if (!stampedLock.validate(rl)) {
            rl = stampedLock.readLock();
            try {
                readKey = key;
            } finally {
                stampedLock.unlockRead(rl);
            }
        }
        if (readKey != null) {
            return readKey;
        }
        long wl = stampedLock.writeLock();
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
            stampedLock.unlockWrite(wl);
        }
    }
}