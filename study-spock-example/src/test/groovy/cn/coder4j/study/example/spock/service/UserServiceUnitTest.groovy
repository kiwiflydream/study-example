/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */

package cn.coder4j.study.example.spock.service

import cn.coder4j.study.example.spock.dao.UserDao
import cn.coder4j.study.example.spock.model.User
import spock.lang.Specification
import spock.lang.Unroll

class UserServiceUnitTest extends Specification {

    UserService userService = new UserService()
    UserDao userDao = Mock(UserDao)

    def setup() {
        userService.userDao = userDao
    }

    def "test login with success"() {

        when:
        userService.login("k", "p")

        then:
        1 * userDao.findByName("k") >> new User("k", 12, "p")
    }

    def "test login with error"() {
        given:
        def name = "k"
        def passwd = "p"

        when:
        userService.login(name, passwd)

        then:
        1 * userDao.findByName(name) >> null

        then:
        def e = thrown(RuntimeException)
        e.message == "${name}不存在"

    }

    @Unroll
    def "test login with "() {
        when:
        userService.login(name, passwd)

        then:
        userDao.findByName("k") >> null
        userDao.findByName("k1") >> new User("k1", 12, "p")

        then:
        def e = thrown(RuntimeException)
        e.message == errMsg

        where:
        name | passwd | errMsg
        "k"  | "k"    | "${name}不存在"
        "k1" | "p1"   | "${name}密码输入错误"

    }
}
