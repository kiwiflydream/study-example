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

class UserDaoTest extends Specification {

    def "test findByName by with"() {
        given:
        def userDao = Mock(UserDao)

        when:
        userDao.findByName("kk") >> new User("kk", 12, "33")

        then:
        def user = userDao.findByName("kk")
        with(user) {
            name == "kk"
            age == 12
            passwd == "33"
        }

    }

    def "test findByName by verity"() {
        given:
        def userDao = Mock(UserDao)

        when:
        userDao.findByName("kk") >> new User("kk", 12, "33")

        then:
        def user = userDao.findByName("kk")
        with(user) {
            name == "kk"
            age == 12
            passwd == "33"
        }

    }

}
