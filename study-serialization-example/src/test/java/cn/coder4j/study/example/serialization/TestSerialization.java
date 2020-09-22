/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.serialization;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author buhao
 * @version TestSerialization.java, v 0.1 2020-09-17 17:00 buhao
 */
public class TestSerialization {

    /**
     * 序列化对象（保存序列化文件）
     *
     * @throws IOException
     */
    @Test
    public void testSaveSerializationObject() throws IOException {
        // 创建对象
        final HaveSerialization haveSerialization = new HaveSerialization();
        haveSerialization.setName("kiwi");
        haveSerialization.setAge(18);
        // 创建序列化对象保存的文件
        final File file = new File("haveSerialization.ser");
        // 创建对象输出流
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            // 将对象输出到序列化文件
            objectOutputStream.writeObject(haveSerialization);
        }
    }

    /**
     * 反序列化对象（从序列化文件中读取对象）
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testLoadSerializationObject() throws IOException, ClassNotFoundException {
        // 创建对象输出流
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(new File("haveSerialization.ser")))) {
            // 从输出流中创建对象
            final Object obj = objectInputStream.readObject();
            System.out.println(obj);
        }
    }

    /**
     * 测试序列化错误
     *
     * @throws IOException
     */
    @Test(expected = NotSerializableException.class)
    public void testThrowSerializationObject() throws IOException {
        final NoSerialization noSerialization = new NoSerialization();
        noSerialization.setName("kiwi");
        noSerialization.setAge(22);

        final File file = new File("noSerialization.ser");

        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(noSerialization);
        }

    }

    /**
     * 测试包含未序列化的属性的对象
     *
     * @throws IOException
     */
    @Test
    public void testContainsNoSerialization() throws IOException {
        final NoSerialization noSerialization = new NoSerialization();
        noSerialization.setName("kiwi");
        noSerialization.setAge(22);

        final ContainsNoSerialization containsNoSerialization = new ContainsNoSerialization();
        containsNoSerialization.setNoSerialization(new NoSerialization());

        final File file = new File("containsNoSerialization.ser");

        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(containsNoSerialization);
        }
    }

    /**
     * 测试父类实现序列化
     *
     * @throws IOException
     */
    @Test
    public void testExtendParentSerialization() throws IOException {
        final ExtendParentSerialization extendParentSerialization = new ExtendParentSerialization();
        extendParentSerialization.setName("kiwi");
        extendParentSerialization.setAge(22);
        extendParentSerialization.setAddress("杭州");

        final File file = new File("extendParentSerialization.ser");

        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(extendParentSerialization);
        }

    }

    /**
     * 测试序列化通过json
     */
    @Test
    public void testSerializationByJSON() {
        //-------------序列化操作---------------
        // 创建对象
        final HaveSerialization haveSerialization = new HaveSerialization();
        haveSerialization.setName("kiwi");
        haveSerialization.setAge(18);

        // 序列化成 JSON 字符串
        final String jsonString = JSON.toJSONString(haveSerialization);
        System.out.println("JSON:" + jsonString);

        //-------------反序列化操作---------------
        final HaveSerialization haveSerializationByJSON = JSON.parseObject(jsonString, HaveSerialization.class);
        System.out.println(haveSerializationByJSON);
    }

    /**
     * 测试序列化通过kryo
     */
    @Test
    public void testSerializationByKryo() throws FileNotFoundException {
        //-------------序列化操作---------------
        // 创建对象
        final HaveSerialization haveSerialization = new HaveSerialization();
        haveSerialization.setName("kiwi");
        haveSerialization.setAge(18);

        final Kryo kryo = new Kryo();
        // 注册序列化类
        kryo.register(HaveSerialization.class);

        // 序列化操作
        try (final Output output = new Output(new FileOutputStream("haveSerialization.kryo"))) {
            kryo.writeObject(output, haveSerialization);
        }

        // 反序列化
        try (final Input input = new Input(new FileInputStream("haveSerialization.kryo"))) {
            final HaveSerialization haveSerializationByKryo = kryo.readObject(input, HaveSerialization.class);
            System.out.println(haveSerializationByKryo);
        }
    }
}