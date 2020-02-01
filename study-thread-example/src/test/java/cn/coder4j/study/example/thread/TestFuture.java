/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author buhao
 * @version TestFutrue.java, v 0.1 2020-01-31 21:17 buhao
 */
public class TestFuture {
    /**
     * 测试 FutureTask 获得线程结果
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " run");
            return 666;
        });
        Executors.newSingleThreadExecutor().submit(futureTask);
        System.out.println(Thread.currentThread().getName() + " get " + futureTask.get());
    }

    @Test
    public void testSubmit() throws ExecutionException, InterruptedException {
        Integer result = Executors.newSingleThreadExecutor().submit(() -> {
            System.out.println(Thread.currentThread().getName() + " run");
            return 666;
        }).get();
        System.out.println(Thread.currentThread().getName() + " get " + result);
    }

    @Test
    public void testSubmitWithResult() throws ExecutionException, InterruptedException {
        MyResult param = new MyResult();
        param.setResult(1);
        // todo: 构造函数与 result 必须是同一个对象，并且似乎 Integer 不可以？待考证
        MyResult runResult = Executors.newSingleThreadExecutor().submit(new RunTask(param), param).get();
        System.out.println(runResult.getResult());
    }
}

class RunTask implements Runnable {

    private MyResult result;

    public RunTask(MyResult result) {
        this.result = result;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
        result.setResult(3);
    }
}

class MyResult {
    private Integer result;

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(Integer result) {
        this.result = result;
    }
}