/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */

package cn.coder4j.study.example.dubbo.provider;

import cn.coder4j.study.example.dubbo.DemoService;
import cn.coder4j.study.example.dubbo.model.Person;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        logger.info("Hello " + name + ", request from provider: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name;
    }

    @Override
    public Person findGirlFriend(Person person) {
        Person girlFriend = new Person();
        girlFriend.setName("小萍");
        girlFriend.setAge(18);
        logger.info(person + " 面向 " + girlFriend + "编程");
        return girlFriend;
    }

    @Override
    public List<Person> findPersionList(List<Person> persions) {

        Person person = new Person();
        person.setName("k1");
        person.setAge(1);

        Person person2 = new Person();
        person2.setName("k2");
        person2.setAge(2);

        return Lists.newArrayList(person, person2);
    }

}
