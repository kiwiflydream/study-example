/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */

package cn.coder4j.study.example.spock.util

import spock.lang.Specification

class DateUtilUnitTest extends Specification {

    def "test getNowDateStr"() {
        when:
        def nowStr = DateUtil.getNowDateStr()

        then:
        nowStr == "2019-11-05"
    }
}
