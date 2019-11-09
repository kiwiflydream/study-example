/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package cn.coder4j.study.example.thread;

import java.util.LinkedList;

/**
 * 老板
 *
 * @author buhao
 * @version Boss.java, v 0.1 2019-11-09 15:09 buhao
 */
public class Boss implements Runnable {
    /**
     * 最大生产数量
     */
    public static final int MAX_NUM = 5;
    /**
     * 桌子
     */
    private LinkedList<String> tables;

    public Boss(LinkedList<String> tables) {
        this.tables = tables;
    }

    @Override
    public void run() {
        // 注意点1
        while (true) {
            synchronized (this.tables) {
                // 注意点2
                while (tables.size() == MAX_NUM) {
                    System.out.println("通知外卖小哥取餐");
                    // 注意点3
                    this.tables.notifyAll();
                    try {
                        System.out.println("老板开始休息了");
                        this.tables.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String goods = "牛肉面" + tables.size();
                System.out.println("老板做了一碗" + goods);
                tables.addLast(goods);
            }
        }
    }
}