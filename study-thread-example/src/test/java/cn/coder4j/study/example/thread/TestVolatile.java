/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.thread;

/**
 * @author buhao
 * @version TestVolatile.java, v 0.1 2019-09-27 15:46 buhao
 */
public class TestVolatile {

    //    private volatile boolean flag = false;
    private boolean flag = false;

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " start");
            while (!testVolatile.isFlag()) {
            }
            System.out.println(name + " end");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            testVolatile.setFlag(true);
            System.out.println(name + " 设置 flag = " + testVolatile.isFlag());
        }).start();

    }

//    public synchronized boolean  isFlag() {
//        return flag;
//    }

    /**
     * Getter method for property <tt>flag</tt>.
     *
     * @return property value of flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Setter method for property <tt>flag</tt>.
     *
     * @param flag value to be assigned to property flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}