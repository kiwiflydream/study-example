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
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author buhao
 * @version TestForkJoin.java, v 0.1 2020-01-30 13:10 buhao
 */
public class TestForkJoin {
    public static void main(String[] args) {
        // 创建 fork/join 线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        // 创建 fork/join 任务
        List<Integer> nums = Lists.newArrayList();
        for (int i = 0; i <= 400; i++) {
            nums.add(i);
        }
        SumForkTask task = new SumForkTask(nums.toArray(new Integer[]{}), 0, nums.size());
        // 提交任务到线程池
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        long startTime = System.currentTimeMillis();
        // 启动任务
        submit.invoke();
        System.out.println("执行时间:" + (System.currentTimeMillis() - startTime) / 10 + "s");
        try {
            // 打印结果
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class SumForkTask extends RecursiveTask<Integer> {

    private final Integer MAX_NUM = 100;
    private Integer[] nums;
    private Integer start;
    private Integer end;

    public SumForkTask(Integer[] nums, Integer start, Integer end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        // 确定最小任务条件
        if ((end - start) <= MAX_NUM) {
            int total = 0;
            for (int i = start; i < end; i++) {
                total += nums[i];
            }
            ThreadUtil.sleep(1000);
            return total;
        }
        // 任务拆分成两部分
        int middle = (end + start) / 2;
        SumForkTask sumForkTaskPart1 = new SumForkTask(nums, start, middle);
        SumForkTask sumForkTaskPart2 = new SumForkTask(nums, middle, end);
        // 异步执行第一部分任务
        sumForkTaskPart1.fork();
        // 合并结果,这两种写法都都可以，但是要记得 join 要放最后
        return sumForkTaskPart2.compute() + sumForkTaskPart1.join();
//        invokeAll(sumForkTaskPart1, sumForkTaskPart2);
//        return sumForkTaskPart1.join() + sumForkTaskPart2.join();
    }
}