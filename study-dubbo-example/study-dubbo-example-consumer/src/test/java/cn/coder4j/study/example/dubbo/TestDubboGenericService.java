/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.dubbo;

import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;
import org.junit.Test;

/**
 * @author buhao
 * @version TestDubboGenericService.java, v 0.1 2019-09-17 10:13 buhao
 */
public class TestDubboGenericService extends BaseTest {


    @Test
    public void testMockProvider() {

        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口实现
        GenericService myService = new CommonGenericService();

        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ServiceConfig<GenericService> service = new ServiceConfig<>();
        // 弱类型接口名
        service.setInterface("cn.coder4j.study.example.dubbo.DemoService");
        service.setVersion("1.0.0");
        // 指向一个通用服务实现
        service.setRef(myService);

        // 暴露及注册服务
        service.export();

        while (true) {
        }
    }
}

class CommonGenericService implements GenericService {


    @Override
    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        return "mock success";
    }
}