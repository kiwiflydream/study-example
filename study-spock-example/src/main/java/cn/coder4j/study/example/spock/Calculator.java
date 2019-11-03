/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.spock;

/**
 * @author buhao
 * @version Calculator.java, v 0.1 2019-10-30 10:34 buhao
 */
public class Calculator {

    /**
     * 加操作
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * 整型除操作
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int divideInt(int num1, int num2) {
        return num1 / num2;
    }

    /**
     * 浮点型操作
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double divideDouble(double num1, double num2) {
        return num1 / num2;
    }
}