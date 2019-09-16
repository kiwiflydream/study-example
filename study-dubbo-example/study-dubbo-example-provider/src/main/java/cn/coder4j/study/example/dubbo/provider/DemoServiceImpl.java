package cn.coder4j.study.example.dubbo.provider;

import cn.coder4j.study.example.dubbo.DemoService;
import cn.coder4j.study.example.dubbo.model.Person;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        logger.info("Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
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

}
