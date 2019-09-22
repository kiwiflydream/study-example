/*
 * *
 *  * blog.coder4j.cn
 *  * Copyright (C) 2016-2019 All Rights Reserved.
 *
 */
package cn.coder4j.study.example.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author buhao
 * @version TestController.java, v 0.1 2019-09-19 20:53 buhao
 */
@RequestMapping("/test")
@Controller
public class TestController {

    /**
     * 没有注解通过自适应的限流
     *
     * @return
     */
    @GetMapping("/flowRule")
    @ResponseBody
    public String flowRule() {
        return "success";
    }

    /**
     * 通过手动注解的限流
     *
     * @return
     */
    @GetMapping("/flowRuleWithAnno")
    @ResponseBody
    @SentinelResource("flowRuleWithAnno")
    public String flowRuleWithAnno() {
        return "success";
    }

    /**
     * 参数限流规则测试
     *
     * @param param
     * @return
     */
    @GetMapping("/paramFlowRule")
    @ResponseBody
    @SentinelResource("paramFlowRule")
    public String paramFlowRule(String param) {
        return "success";
    }

    /**
     * 熔断规则测试
     *
     * @return
     */
    @GetMapping("/degradeRule")
    @ResponseBody
    @SentinelResource("degradeRule")
    public String degradeRule() {
        throw new RuntimeException("服务器异常");
    }
}