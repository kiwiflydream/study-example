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
 * @version AccountByLock.java, v 0.1 2020-01-28 17:10 buhao
 */
public class AccountByLock {
    // 锁
    private Lock lock = new ReentrantLock();
    // 余额
    private Integer balance;

    public AccountByLock(Integer balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        // 用户 A
        AccountByLock accountA = new AccountByLock(100);
        // 用户 B
        AccountByLock accountB = new AccountByLock(100);

        while (accountA.getBalance().equals(accountB.getBalance())) {
            Thread threadA = new Thread(() -> accountA.transfer(accountB, 20));
            Thread threadB = new Thread(() -> accountB.transfer(accountA, 20));
            threadA.start();
            threadB.start();
            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("A=" + accountA.getBalance() + " B=" + accountB.getBalance());
    }

    /**
     * Getter method for property <tt>balance</tt>.
     *
     * @return property value of balance
     */
    public Integer getBalance() {
        return balance;
    }

    // 转账
    public void transfer(AccountByLock account, Integer amt) {
        lock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += amt;
            account.balance -= amt;
        } finally {
            lock.unlock();
        }

    }
}