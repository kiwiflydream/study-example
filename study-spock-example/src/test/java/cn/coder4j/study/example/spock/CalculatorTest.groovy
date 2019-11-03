/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */

package cn.coder4j.study.example.spock


import spock.lang.Specification
import spock.lang.Unroll

class CalculatorTest extends Specification {

    def setup() {}

    def cleanup() {}

    def setupSpec() {}

    def cleanupSpec() {}

    def "test add with expect"() {
        expect:
        Calculator.add(1, 1) == 2
        Calculator.add(1, 2) == 3
        Calculator.add(1, 3) == 4
    }

    def "test add with expect where"() {
        expect:
        Calculator.add(num1, num2) == result

        where:
        num1 | num2 | result
        1    | 1    | 2
        1    | 2    | 3
        1    | 3    | 4
    }

    @Unroll
    def "test add with expect where unroll"() {
        expect:
        Calculator.add(num1, num2) == result

        where:
        num1 | num2 | result
        1    | 1    | 2
        1    | 2    | 3
        1    | 3    | 5
    }

    @Unroll
    def "test add with expect where unroll by #num1 + #num2 = #result"() {
        expect:
        Calculator.add(num1, num2) == result

        where:
        num1 | num2 | result
        1    | 1    | 2
        1    | 2    | 3
        1    | 3    | 5
    }

    @Unroll
    def "test add with expect where unroll arr by #num1 + #num2 = #result"() {
        expect:
        Calculator.add(num1, num2) == result

        where:
        num1 << [1, 1, 2]
        num2 << [1, 2, 3]
        result << [1, 3, 4]
    }

    def "test add with given"() {
        given:
        def num1 = 1
        def num2 = 1
        def result = 2

        expect:
        Calculator.add(num1, num2) == result
    }

    def "test add with given and"() {
        given:
        def num1 = 1
        def num2 = 1

        and:
        def result = 1

        expect:
        Calculator.add(num1, num2) == result
    }

    /**
     * expect ... where...
     * @return
     */
    @Unroll
    def "test add by  #a + #b = #result"() {
        expect:
        Calculator.add(a, b) == result

        where:
        a | b | result
        1 | 1 | 2
        2 | 2 | 4
        1 | 3 | 2
    }

    /**
     * when ... then...
     * @return
     */
    @Unroll
    def "test int divide zero exception"() {
        when:
        Calculator.divideInt(1, 0)

        then:
        def ex = thrown(ArithmeticException)
        ex.message == "/ by zero"
    }

    @Unroll
    def "test int divide by #a / #b = #result"() {
        expect:
        Calculator.divideInt(a, b) == result

        where:
        a | b | result
        0 | 1 | 0
        1 | 1 | 1

    }

    @Unroll
    def "test double divide by #a / #b = #result"() {
        expect:
        Calculator.divideDouble(a, b) == result

        where:
        a                        | b                        | result
        -1.0                     | 0                        | Double.NEGATIVE_INFINITY
        1.0                      | 0                        | Double.POSITIVE_INFINITY
        Double.POSITIVE_INFINITY | Double.POSITIVE_INFINITY | Double.NaN

    }
}
