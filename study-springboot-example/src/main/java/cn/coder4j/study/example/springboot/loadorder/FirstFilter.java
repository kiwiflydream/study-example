/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.springboot.loadorder;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author buhao
 * @version FirstFilter.java, v 0.1 2019-11-12 21:17 buhao
 */
@Component
public class FirstFilter extends BaseFilter implements Ordered {

    @Override
    public int getOrder() {
        return 0;
    }
}