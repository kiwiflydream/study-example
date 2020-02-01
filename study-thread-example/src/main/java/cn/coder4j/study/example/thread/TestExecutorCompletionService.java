/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author buhao
 * @version TestExecutorCompletionService.java, v 0.1 2020-01-31 22:19 buhao
 */
public class TestExecutorCompletionService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorCompletionService service = new ExecutorCompletionService(Executors.newFixedThreadPool(2));
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                service.submit(() -> {
                    ThreadUtil.sleep(1000);
                    return 2;
                });
            } else {
                service.submit(() -> {
                    return 1;
                });
            }
        }
        while (true) {
            Future take = service.take();
            System.out.println(take.get());
        }
    }
}