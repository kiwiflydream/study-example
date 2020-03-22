/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.qdox;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author buhao
 * @version DemoParser.java, v 0.1 2020-03-22 19:03 buhao
 */
public class DemoParser {
    public static void main(String[] args) throws IOException {
        // 创建 java 项目 builder 对象
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        // 添加 java 源文件
        javaProjectBuilder.addSource(new File("/Users/kiwi/study/code/study-example/study-qdox-example/src/main/java/cn/coder4j/study/example/qdox/Demo.java"));
        // 获得解析后的类
        Collection<JavaClass> classes = javaProjectBuilder.getClasses();
        for (JavaClass javaClass : classes) {
            // 打印类相关信息
            System.out.println("类名:" + javaClass.getName());
            System.out.println("实现了哪些类：" + javaClass.getImplements());
            System.out.println("继承哪个类：" + javaClass.getSuperJavaClass());
            System.out.println("注释：" + javaClass.getComment());
            // 获得方法列表
            List<JavaMethod> methods = javaClass.getMethods();
            for (JavaMethod method : methods) {
                System.out.println("方法名是：" + method.getName());
                System.out.println("方法的 Tags 有哪些：" + method.getTags().stream().map(it -> it.getName() + "->" + it.getValue()).collect(Collectors.joining("\n")));
                System.out.println("方法的参数有哪些：" + method.getParameters());
                System.out.println("方法的返回值有哪些：" + method.getReturns());
            }
        }
    }
}