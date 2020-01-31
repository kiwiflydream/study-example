/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

/**
 * @author buhao
 * @version AccountBySynchronized.java, v 0.1 2020-01-28 16:28 buhao
 */
public class AccountBySynchronized {
    // 余额
    private Integer balance;

    public AccountBySynchronized(Integer balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        // 用户 A
        AccountBySynchronized accountA = new AccountBySynchronized(100);
        // 用户 B
        AccountBySynchronized accountB = new AccountBySynchronized(100);

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
        // 这里必须加synchronized，因为这里没有原子性问题，但是有可见性问题
        synchronized (AccountBySynchronized.class) {
            return balance;
        }
    }

    // 转账
    public void transfer(AccountBySynchronized account, Integer amt) {
        // 效率低，全串行化
        synchronized (AccountBySynchronized.class) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += amt;
            account.balance -= amt;
        }
    }
}