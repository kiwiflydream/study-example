/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.jvm;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;

/**
 * @author buhao
 * @version JstackAnalyze.java, v 0.1 2019-11-06 16:26 buhao
 */
public class JstackAnalyze {

    public static void main(String[] args) {
        String str = "\"nioEventLoopGroup-10-8\" #497 prio=10 os_prio=0 tid=0x00007fe5b4250000 nid=0x7d93 runnable [0x00007fe56094d000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "\tat sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)\n" +
                "\tat sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)\n" +
                "\tat sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)\n" +
                "\tat sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)\n" +
                "\t- locked <0x00000007b8ec53e0> (a io.netty.channel.nio.SelectedSelectionKeySet)\n" +
                "\t- locked <0x00000007b8ec53f8> (a java.util.Collections$UnmodifiableSet)\n" +
                "\t- locked <0x00000007b8ec5398> (a sun.nio.ch.EPollSelectorImpl)\n" +
                "\tat sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)\n" +
                "\tat io.netty.channel.nio.SelectedSelectionKeySetSelector.select(SelectedSelectionKeySetSelector.java:62)\n" +
                "\tat io.netty.channel.nio.NioEventLoop.select(NioEventLoop.java:756)\n" +
                "\tat io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:411)\n" +
                "\tat io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:884)\n" +
                "\tat io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\n" +
                "\tat java.lang.Thread.run(Thread.java:748)";
        String[] lines = str.split("\n");
        System.out.println("线程信息：");
        System.out.println(lines[0]);
        System.out.println("线程状态：");
        System.out.println(lines[1]);
        System.out.println("线程堆栈：");
        System.out.println(StrUtil.join("\n", Lists.newArrayList(lines).subList(2, lines.length - 1)));
    }
}