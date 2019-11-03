/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.spock.model;

import java.util.Objects;

/**
 * @author buhao
 * @version User.java, v 0.1 2019-10-30 16:23 buhao
 */
public class User {
    private String name;
    private Integer age;
    private String passwd;

    public User(String name, Integer age, String passwd) {
        this.name = name;
        this.age = age;
        this.passwd = passwd;
    }

    public User() {
    }

    /**
     * Getter method for property <tt>passwd</tt>.
     *
     * @return property value of passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Setter method for property <tt>passwd</tt>.
     *
     * @param passwd value to be assigned to property passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(passwd, user.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passwd);
    }
}