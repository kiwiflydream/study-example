/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.designpattern.simplefactory;

/**
 * @author buhao
 * @version SimpleFactoryContext.java, v 0.1 2020-09-10 19:40 buhao
 */
public class SimpleFactoryContext {
    public static void main(String[] args) {
        // 创建工厂类
        final ClothingFactory factory = new ClothingFactory();
        // 生产上衣
        final ClothesProduct coat = factory.create(ClothesType.COAT);
        System.out.println("生产 --- " + coat.make());
        // 生产裤子
        final ClothesProduct pants = factory.create(ClothesType.PANTS);
        System.out.println("生产 --- " + pants.make());
    }
}