/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package cn.coder4j.study.example.spock.util;

import java.time.LocalDate;

/**
 * @author buhao
 * @version DateUtil.java, v 0.1 2019-11-04 14:41 buhao
 */
public class DateUtil {

    public static String getNowDateStr() {
        return LocalDate.now().toString();
    }

}