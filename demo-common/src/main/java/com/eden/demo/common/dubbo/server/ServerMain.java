/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.eden.demo.common.dubbo.server;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by zhaoxianghui on 2017/11/7.
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]
                                                                                            {"spring/applicationProvider.xml"});
        context.start();

        System.out.println("输入任意按键退出 ~ ");
        System.in.read();
        context.close();

    }
}
