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
 * @version ClothesType.java, v 0.1 2020-09-10 19:06 buhao
 */
public enum ClothesType {
    /**
     * 上衣
     */
    COAT("上衣", "COAT"),
    /**
     * 裤子
     */
    PANTS("裤子", "PANTS");

    private String name;
    private String value;

    ClothesType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public String getValue() {
        return value;
    }
}
