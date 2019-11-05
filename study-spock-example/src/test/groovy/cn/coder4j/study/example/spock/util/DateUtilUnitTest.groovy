package cn.coder4j.study.example.spock.util

import spock.lang.Specification

/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
class DateUtilUnitTest extends Specification {

    def "test getNowDateStr"() {
        when:
        def nowStr = DateUtil.getNowDateStr()

        then:
        nowStr == "2019-11-05"
    }
}
