/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author buhao
 * @version TestCache.java, v 0.1 2020-10-19 21:52 buhao
 */
public class TestCache {

    @Test
    @DisplayName("测试 LoadingCache 创建")
    public void testLoadingCache() throws ExecutionException, InterruptedException {
        final LoadingCache<String, String> cache = CacheBuilder
                .newBuilder()
                // 同时写入缓存的线程数
                .concurrencyLevel(10)
                // 访问多久后过期
                .expireAfterAccess(5, TimeUnit.SECONDS)
                // 写入多久后过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                // 最大的内存空间
//                .maximumWeight(1024)
                // 写入后多久刷新
                .refreshAfterWrite(30, TimeUnit.SECONDS)
                // 初始化的容器大小
                .initialCapacity(1)
                // 缓存最大容量，到了之后就会淘汰
                .maximumSize(10)
                // 开启命中率统计
                .recordStats()
                // 添加缓存删除监控
                .removalListener(removalNotification
                        -> System.out.println(removalNotification.getKey() + " 淘汰"))
                // 缓存不存在时，如果获取
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key + "-123";
                    }
                });

        cache.put("122", "3333");

        System.out.println(cache.get("122"));
        System.out.println(cache.get("111"));

        TimeUnit.SECONDS.sleep(30);
    }

    @Test
    public void testCallable() throws ExecutionException {
        final Cache<String, String> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .build();

        final String cacheKey = "kiwi";
        final String value = cache.get(cacheKey, () -> cacheKey + "-value");

        System.out.println(value);
    }

    @Test
    public void testBuilder() throws ExecutionException {

        final LoadingCache<String, String> loadingCache = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "value";
                    }
                });
        loadingCache.get("key");

        final Cache<Object, Object> callableCache = CacheBuilder
                .newBuilder()
                .build();
        callableCache.get("key", () -> "value");
    }
}