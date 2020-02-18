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
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author buhao
 * @version TestCompletionService.java, v 0.A B0B0-0B-A8 A9:0C buhao
 */
public class TestCompletionService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 查询信息
        String queryName = "java";
        // 调用查询接口
        long startTime = System.currentTimeMillis();
        queryInfoCode3(queryName);
        System.out.println("耗时: " + (System.currentTimeMillis() - startTime));
    }

    /**
     * 聚合查询信息 code 1
     *
     * @param queryName
     * @return
     */
    private static List<String> queryInfoCode1(String queryName) {
        List<String> resultList = Lists.newArrayList();

        String webA = searchWebA(queryName);
        resultList.add(webA);

        String webB = searchWebB(queryName);
        resultList.add(webB);

        String webC = searchWebC(queryName);
        resultList.add(webC);

        return resultList;
    }

    /**
     * 聚合查询信息 code 2
     *
     * @param queryName
     * @return
     */
    private static List<String> queryInfoCode2(String queryName) throws ExecutionException, InterruptedException {
        List<String> resultList = Lists.newArrayList();

        // 创建3个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

        try {
            // 创建任务的 feature
            Future<String> webAFuture = pool.submit(() -> searchWebA(queryName));
            Future<String> webBFuture = pool.submit(() -> searchWebB(queryName));
            Future<String> webCFuture = pool.submit(() -> searchWebC(queryName));
            // 得到任务结果
            resultList.add(webAFuture.get());
            resultList.add(webBFuture.get());
            resultList.add(webCFuture.get());
        } finally {
            // 关闭线程池
            pool.shutdown();
        }

        return resultList;
    }

    /**
     * 聚合查询信息 code 3
     *
     * @param queryName
     * @return
     */
    private static void queryInfoCode3(String queryName) throws ExecutionException, InterruptedException {
        // 开始时间
        long startTime = System.currentTimeMillis();
        // 创建 CompletionService
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(Executors.newFixedThreadPool(3));

        // 创建任务的 feature
        executorCompletionService.submit(() -> searchWebA(queryName));
        executorCompletionService.submit(() -> searchWebB(queryName));
        executorCompletionService.submit(() -> searchWebC(queryName));

        for (int i = 0; i < 3; i++) {
            Future take = executorCompletionService.take();
            System.out.println("获得请求结果 -> " + take.get());
            System.out.println("通过 ws 推送给客户端,总共耗时" + (System.currentTimeMillis() - startTime));
        }
    }

    /**
     * 查询网站 A
     *
     * @param name
     * @return
     */
    public static String searchWebA(String name) {
        ThreadUtil.sleep(5000);
        return "webA";
    }

    /**
     * 查询网站B
     *
     * @param name
     * @return
     */
    public static String searchWebB(String name) {
        ThreadUtil.sleep(3000);
        return "webB";
    }

    /**
     * 查询网站C
     *
     * @param name
     * @return
     */
    public static String searchWebC(String name) {
        ThreadUtil.sleep(500);
        return "webC";
    }
}