/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package cn.coder4j.study.example.springboot.loadorder;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author buhao
 * @version LastFilter.java, v 0.1 2019-11-12 21:17 buhao
 */
@Component
public class LastFilter extends BaseFilter implements Ordered {

    @Override
    public int getOrder() {
        return 1;
    }
}