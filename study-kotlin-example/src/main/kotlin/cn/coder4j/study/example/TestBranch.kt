/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */

package cn.coder4j.study.example

/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */

fun main() {
    testWhen()
}


fun testWhen() {
    validateWhen(0)
    validateWhen(4)
    validateWhen('4')
    validateWhen("hello")
    validateWhen(9)

}

fun validateWhen(obj: Any?) {
    when (obj) {
        0, 1, 3 -> println("$obj 是0到3的数字")
        is Char -> println("$obj 是一个字符")
        "hello" -> println("$obj 是 hello")
        in 4..10 -> println("$obj 在 4到10之间")
        else -> println("其实都错了，是$obj")
    }
}