/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package cn.coder4j.study.example.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author buhao
 * @version TestCurator.java, v 0.1 2019-11-07 10:01 buhao
 */
public class TestCurator {

    private CuratorFramework client;

    /**
     * 初始化客户端
     */
    @Before
    public void initClient() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        client.start();
    }

    /**
     * 关闭连接
     */
    @After
    public void closeClient() {
        client.close();
    }

    /**
     * 获得子节点
     */
    @Test
    public void readPath() {
        try {
            List<String> nodes = client.getChildren().forPath("/");
            System.out.println(nodes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据
     *
     * @throws Exception
     */
    @Test
    public void readData() throws Exception {
        client.getChildren().forPath("/test");
    }
}