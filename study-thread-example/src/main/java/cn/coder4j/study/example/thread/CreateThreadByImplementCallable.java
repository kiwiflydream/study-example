/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author buhao
 * @version CreateThreadByImplementCallable.java, v 0.1 2021-01-30 11:40 buhao
 */
public class CreateThreadByImplementCallable implements Callable<String> {
    public static void main(String[] args) {
        // 创建异步任务
        final FutureTask<String> stringFutureTask = new FutureTask<>(new CreateThreadByImplementCallable());

        // 启动线程
        new Thread(stringFutureTask).start();

        System.out.println("执行其它操作");

        try {
            // 等待任务完成，并获得返回值
            final String result = stringFutureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        System.out.println("执行开始");
        Thread.sleep(3000);
        System.out.println("执行结束");
        return "hello";
    }
}