/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.serialization;

import java.util.StringJoiner;

/**
 * @author buhao
 * @version ExtendParentSerialization.java, v 0.1 2020-09-17 23:13 buhao
 */
public class ExtendParentSerialization extends HaveSerialization {
    private String address;

    /**
     * Getter method for property <tt>address</tt>.
     *
     * @return property value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for property <tt>address</tt>.
     *
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExtendParentSerialization.class.getSimpleName() + "[", "]")
                .add("address='" + address + "'")
                .toString();
    }
}