/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.eden.demo.common.dubbo.impl;

import com.eden.demo.common.dubbo.api.DemoService;

/**
 * Create by zhaoxianghui on 2017/11/7.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("init : " + name);
        return "hello " + name;
    }
}
