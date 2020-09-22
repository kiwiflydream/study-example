/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.designpattern.simplefactory;

import cn.coder4j.study.example.designpattern.simplefactory.impl.CoatProduct;
import cn.coder4j.study.example.designpattern.simplefactory.impl.PantsProduct;

/**
 * 服务店
 *
 * @author buhao
 * @version ClothingFactory.java, v 0.1 2020-09-10 19:03 buhao
 */
public class ClothingFactory {

    /**
     * 创建
     *
     * @param type
     * @return
     */
    public ClothesProduct create(ClothesType type) {
        switch (type) {
            case COAT:
                return new CoatProduct();
            case PANTS:
                return new PantsProduct();
            default:
                throw new RuntimeException("无效的服饰类型！");
        }
    }
}