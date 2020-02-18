/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */

package cn.coder4j.study.example

//1. 定义变量
var a: Int = 0
//1.1 类型推导
var a1 = 0

//2. 定义常量
val b = 1

//3. 定义方法
fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}

//3.1 除非没有返回值，否则不能省略方法的返回类型
fun hello(name: String) {
    println("hello $name")
}

//3.2 表达式方法
fun add1(num1: Int, num2: Int): Int = num1 + num2

//3.2.1 表达式方法可以省略方法类似（包含递归的除外）
fun add2(num1: Int, num2: Int) = num1 + num2

//3.2.2 参数是函数的函数
fun queryUser(test: (String) -> Boolean) {
    val userList = arrayListOf<String>("kiwi", "kiwifly", "tom")
    for (s in userList) {
        if (test(s)) {
            println(s)
        }
    }
}

fun main() {
    queryUser(fun(name: String): Boolean = name.startsWith("kiwi"))
}
