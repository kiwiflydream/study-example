/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.qdox;

import java.io.Serializable;

/**
 * 这是一个 demo 类
 *
 * @author buhao
 * @version Demo.java, v 0.1 2020-03-22 16:05 buhao
 */
public class Demo implements Serializable {

    private static final long serialVersionUID = 3130244346327152048L;

    private String age;

    /**
     * 打招呼
     *
     * @param name 姓名
     * @return hello {name}
     */
    private String hello(String name) {
        return "hello" + name;
    }
}