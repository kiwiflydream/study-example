/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package cn.coder4j.study.example.dubbo.model;

import java.io.Serializable;

/**
 * @author buhao
 * @version Person.java, v 0.1 2019-09-16 19:28 buhao
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 2388188740899918589L;

    private String name;
    private int age;

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
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }
}