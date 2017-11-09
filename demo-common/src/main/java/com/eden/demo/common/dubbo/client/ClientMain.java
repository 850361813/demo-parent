/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.eden.demo.common.dubbo.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eden.demo.common.dubbo.api.DemoService;

/**
 * Create by zhaoxianghui on 2017/11/7.
 */
public class ClientMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring/applicationConsumer.xml"});
        context.start();
        DemoService service = (DemoService) context.getBean("demoService");
        System.out.println(service.sayHello("world"));
        context.close();
    }
}
