/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2019 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.dubbo.provider;


import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.remoting.Channel;
import org.apache.dubbo.remoting.telnet.TelnetHandler;
import org.apache.dubbo.remoting.telnet.support.Help;

/**
 * @author buhao
 * @version HelloTelnetHandler.java, v 0.1 2019-11-19 14:09 buhao
 */
@Activate
@Help(summary = "test telnet", detail = "test telnet")
public class HelloTelnetHandler implements TelnetHandler {
    /**
     * telnet.
     *
     * @param channel
     * @param message
     */
    @Override
    public String telnet(Channel channel, String message) {
        return "success";
    }
}