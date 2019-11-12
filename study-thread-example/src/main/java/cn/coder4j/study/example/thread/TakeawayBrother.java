/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.LinkedList;

/**
 * 外卖小哥
 *
 * @author buhao
 * @version TakeawayBrother.java, v 0.1 2019-11-09 15:14 buhao
 */
public class TakeawayBrother implements Runnable {

    private LinkedList<String> tables;

    public TakeawayBrother(LinkedList<String> tables) {
        this.tables = tables;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.tables) {
                while (this.tables == null || this.tables.size() == 0) {
                    System.out.println("催老板赶快做外卖");
                    this.tables.notifyAll();
                    try {
                        System.out.println("一边玩手机一边等外卖");
                        this.tables.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String goods = tables.removeFirst();
                System.out.println("外卖小哥取餐了" + goods);
            }
        }
    }
}