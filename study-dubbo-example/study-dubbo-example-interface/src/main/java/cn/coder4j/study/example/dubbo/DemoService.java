package cn.coder4j.study.example.dubbo;

import cn.coder4j.study.example.dubbo.model.Person;

public interface DemoService {

    String sayHello(String name);

    Person findGirlFriend(Person person);
}