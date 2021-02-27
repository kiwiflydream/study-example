/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.nginx;

import com.github.odiszapc.nginxparser.NgxBlock;
import com.github.odiszapc.nginxparser.NgxConfig;
import org.junit.Test;

import java.io.IOException;

/**
 * @author buhao
 * @version TestNginx.java, v 0.1 2020-10-12 14:10 buhao
 */
public class TestNginx {

    /**
     * 测试创建nginx配置
     */
    @Test
    public void testCreateNginxConfig() throws IOException {
        final NgxConfig config = NgxConfig.read("/usr/local/etc/nginx/nginx.conf", "utf-8");
        final NgxBlock block = config.findBlock("http", "server");
        System.out.println(block);
    }
}