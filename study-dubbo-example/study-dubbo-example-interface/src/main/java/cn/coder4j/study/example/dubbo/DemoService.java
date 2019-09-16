package cn.coder4j.study.example.dubbo;

import cn.coder4j.study.example.dubbo.model.Person;

import java.util.List;

public interface DemoService {

    String sayHello(String name);

    Person findGirlFriend(Person person);

    List<Person> findPersionList(List<Person> persions);
}