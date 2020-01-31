/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author buhao
 * @version TestReentrantLock.java, v 0.1 2020-01-14 21:10 buhao
 */
public class TestReentrantLock {
    private final Lock lock = new ReentrantLock();
}