/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.eden.demo.common.redis;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulConnection;

/**
 * Create by zhaoxianghui on 17/7/17.
 */
public class ConnectToRedis {
    public static void main(String[] args) {
        // Syntax: redis://[password@]host[:port][/databaseNumber]
        RedisClient redisClient = RedisClient.create(RedisURI.create("redis://password@localhost:6379/0"));
        StatefulConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis");

        connection.close();
        redisClient.shutdown();
    }
}
