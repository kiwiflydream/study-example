/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author buhao
 * @version Context.java, v 0.1 2021-02-22 14:13 buhao
 */
public class Context {
    public static void main(String[] args) {
        final ServiceLoader<Log> load = ServiceLoader.load(Log.class);
        final Iterator<Log> iterator = load.iterator();
        while (iterator.hasNext()) {
            final Log log = iterator.next();
            log.info("test");
        }
    }
}