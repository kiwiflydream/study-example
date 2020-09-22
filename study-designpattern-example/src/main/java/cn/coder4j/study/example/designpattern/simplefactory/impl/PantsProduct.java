/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.designpattern.simplefactory.impl;

import cn.coder4j.study.example.designpattern.simplefactory.ClothesProduct;

/**
 * @author buhao
 * @version PantsProduct.java, v 0.1 2020-09-10 19:11 buhao
 */
public class PantsProduct implements ClothesProduct {
    /**
     * 制作
     *
     * @return
     */
    @Override
    public String make() {
        return "裤子";
    }
}