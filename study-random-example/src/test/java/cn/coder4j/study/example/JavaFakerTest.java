/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example;

import com.github.javafaker.Address;
import com.github.javafaker.Avatar;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Locale;

/**
 * @author buhao
 * @version JavaFakerTest.java, v 0.1 2020-08-03 21:00 buhao
 */
public class JavaFakerTest {

    private static Faker faker;

    @BeforeClass
    public static void init() {
        faker = new Faker();
//        faker = new Faker(Locale.CHINA);
    }

    public static void main(String[] args) {
        printTestMethod(Name.class.getName());
    }

    private static void printTestMethod(String className) {

        try {
            final Class<?> clazz = Class.forName(className);
            final String simpleName = clazz.getSimpleName();
            System.out.println("final " + simpleName + " " + simpleName.toLowerCase() + " = faker." + simpleName.toLowerCase() + "();");
            for (Method method : clazz.getDeclaredMethods()) {
                method.setAccessible(true);
                System.out.println("System.out.println(\"" + method.getName() + " : \" + " + simpleName.toLowerCase() + "." + method.getName() + "());");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRandomName() {
        Faker faker = new Faker(Locale.CHINA);
        final Name name = faker.name();
        System.out.println("firstName : " + name.firstName());
        System.out.println("username : " + name.username());
        System.out.println("bloodGroup : " + name.bloodGroup());
        System.out.println("suffix : " + name.suffix());
        System.out.println("title : " + name.title());
        System.out.println("lastName : " + name.lastName());
        System.out.println("nameWithMiddle : " + name.nameWithMiddle());
        System.out.println("fullName : " + name.fullName());
        System.out.println("name : " + name.name());
        System.out.println("prefix : " + name.prefix());
    }

    @Test
    public void testRandomAddress() {
        final Address address = faker.address();
        System.out.println(address.city());
        System.out.println(address.fullAddress());
        System.out.println(address.cityPrefix());
        System.out.println(address.citySuffix());
        System.out.println(address.streetPrefix());
        System.out.println(address.streetSuffix());
        System.out.println(address.buildingNumber());
        System.out.println(address.cityName());
        System.out.println(address.country());
        System.out.println(address.countryCode());
        System.out.println(address.latitude());
        System.out.println(address.longitude());
    }

    @Test
    public void testRandomBook() {
        final Book book = faker.book();
        System.out.println(book.title());
        System.out.println(book.author());
        System.out.println(book.publisher());
        System.out.println(book.genre());
    }

    @Test
    public void testRandomAvatar() {
        final Avatar avatar = faker.avatar();
        System.out.println(avatar.image());
    }
}