/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.serialization;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author buhao
 * @version ContainsNoSerialization.java, v 0.1 2020-09-17 17:35 buhao
 */
public class ContainsNoSerialization implements Serializable {

    private static final long serialVersionUID = -2619988244474114288L;
    private NoSerialization noSerialization;

    /**
     * Getter method for property <tt>serialVersionUID</tt>.
     *
     * @return property value of serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Getter method for property <tt>noSerialization</tt>.
     *
     * @return property value of noSerialization
     */
    public NoSerialization getNoSerialization() {
        return noSerialization;
    }

    /**
     * Setter method for property <tt>noSerialization</tt>.
     *
     * @param noSerialization value to be assigned to property noSerialization
     */
    public void setNoSerialization(NoSerialization noSerialization) {
        this.noSerialization = noSerialization;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ContainsNoSerialization.class.getSimpleName() + "[", "]")
                .add("noSerialization=" + noSerialization)
                .toString();
    }
}