/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.jdk8;

import java.util.Date;
import java.util.StringJoiner;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author buhao
 * @version TestDelayQueue.java, v 0.1 2020-10-20 20:01 buhao
 */
public class TestDelayQueue {

    private static DelayQueue<MyDelayQueue> delayQueue = new DelayQueue<>();

    public static void main(String[] args) throws InterruptedException {
        producer();
        consumer();
    }

    /**
     * 生产者
     */
    public static void producer() {
        delayQueue.add(new MyDelayQueue("b", 4000));
        delayQueue.add(new MyDelayQueue("d", 5000));
        delayQueue.add(new MyDelayQueue("a", 2000));
        delayQueue.add(new MyDelayQueue("d", 3000));
    }

    /**
     * 消费者
     */
    public static void consumer() throws InterruptedException {
        System.out.println(new Date());
        while (!delayQueue.isEmpty()) {
            System.out.println(delayQueue.take());
        }
        System.out.println(new Date());
    }

}

class MyDelayQueue implements Delayed {

    /**
     * 消息
     */
    private String msg;
    /**
     * 延迟时间
     */
    private long delaytime = System.currentTimeMillis();


    public MyDelayQueue(String msg, long delaytime) {
        this.msg = msg;
        this.delaytime = this.delaytime + delaytime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delaytime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }

    /**
     * Getter method for property <tt>msg</tt>.
     *
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property <tt>msg</tt>.
     *
     * @param msg value to be assigned to property msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>delaytime</tt>.
     *
     * @return property value of delaytime
     */
    public long getDelaytime() {
        return delaytime;
    }

    /**
     * Setter method for property <tt>delaytime</tt>.
     *
     * @param delaytime value to be assigned to property delaytime
     */
    public void setDelaytime(long delaytime) {
        this.delaytime = delaytime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyDelayQueue.class.getSimpleName() + "[", "]")
                .add("msg='" + msg + "'")
                .add("delaytime=" + delaytime)
                .toString();
    }
}