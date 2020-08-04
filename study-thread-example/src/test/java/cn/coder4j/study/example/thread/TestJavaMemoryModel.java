/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.thread;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

import java.util.StringJoiner;

/**
 * @author buhao
 * @version TestJavaMemoryModel.java, v 0.1 2020-05-25 14:27 buhao
 */
public class TestJavaMemoryModel {

    @Test
    public void testRule1() {
        // 1
        int x = 0;
        // 2
        System.out.println(x += 1);
    }

    /***
     * {@link TestVolatile}
     */
    @Test
    public void testRule2() {

    }

    @Test
    public void testRule3() throws InterruptedException {
        final Person person = new Person("kiwi", 18);
        final Thread thread = new Thread(() -> {
            ThreadUtil.safeSleep(1000);
            person.setAge(22);
            System.out.println(Thread.currentThread().getName() + "->" + person);
        });
        thread.start();
        thread.join();
        System.out.println("thread -> " + Thread.currentThread().getName() + " person -> " + person);

        ThreadUtil.safeSleep(1000);

    }

    /***
     * {@link TestCount}
     */
    @Test
    public void testRule4() {

    }

    @Test
    public void testRule5() {
        final Person person = new Person("kiwi", 18);
        final Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName() + "->" + person));
        System.out.println("thread -> " + Thread.currentThread().getName());
        person.setAge(22);
        thread.start();
    }


}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}
