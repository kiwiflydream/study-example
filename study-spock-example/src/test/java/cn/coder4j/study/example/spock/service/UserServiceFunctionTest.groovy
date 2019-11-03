/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */

package cn.coder4j.study.example.spock.service

import cn.coder4j.study.example.spock.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class UserServiceFunctionTest extends Specification {

    @Autowired
    UserService userService

    void setup() {
    }

    void cleanup() {
    }

    @Unroll
    def "test findByName with input #name return #result"() {
        expect:
        userService.findByName(name) == result

        where:
        name << ["k", "i", "kk"]
        result << [new User("k", 1, "123"), new User("i", 2, "456"), null]

    }

    @Unroll
    def "test login with input #name and #passwd throw #errMsg"() {
        when:
        userService.login(name, passwd)

        then:
        def e = thrown(Exception)
        e.message == errMsg

        where:
        name | passwd | errMsg
        "kd" | "1"    | "${name}不存在"
        "k"  | "1"    | "${name}密码输入错误"

    }
}
