/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author buhao
 * @version PersonJdkProxy.java, v 0.1 2020-10-14 15:54 buhao
 */
public class JdkProxy implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    /**
     * 新实例
     *
     * @return {@link Object}
     */
    public Object newInstance() {
        final Class<?> targetClass = target.getClass();
        return Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this);
    }

    /**
     * 调用
     *
     * @param proxy  代理
     * @param method 方法
     * @param args   参数
     * @return {@link Object}* @throws Throwable throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行开始");
        final Object result = method.invoke(target, args);
        System.out.println("代理执行结束");
        return result;
    }
}