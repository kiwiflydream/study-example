package cn.coder4j.study.example.spock.util

import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([DateUtil.class])
class DateUtilTest extends Specification {

    def "GetNowDateStr"() {
        setup:
        PowerMockito.mockStatic(DateUtil.class)

        when:
        PowerMockito.when(DateUtil.getNowDateStr()).thenReturn("hi")

        then:
        DateUtil.getNowDateStr() == "hi"
    }
}
