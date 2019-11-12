/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.springboot.loadorder;

import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author buhao
 * @version LastLastFilter.java, v 0.1 2019-11-12 21:33 buhao
 */
@Component
public class LastLastFilter extends BaseFilter implements PriorityOrdered {
    @Override
    public int getOrder() {
        return 9999;
    }
}