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
 * 店铺场景
 *
 * @author buhao
 * @version StoreContext.java, v 0.1 2019-11-09 15:28 buhao
 */
public class StoreContext {

    public static void main(String[] args) {
        // 先创建一张用于存放外卖的桌子
        LinkedList<String> tables = new LinkedList<>();
        // 再创建一个老板
        Boss boss = new Boss(tables);
        // 最后创建一个外卖小哥
        TakeawayBrother takeawayBrother = new TakeawayBrother(tables);
        // 创建线程对象
        Thread bossThread = new Thread(boss);
        Thread takeawayBrotherThread = new Thread(takeawayBrother);
        // 运行线程
        bossThread.start();
        takeawayBrotherThread.start();
    }
}