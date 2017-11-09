/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.eden.demo.common.redis;

import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.cluster.RedisClusterClient;
import com.lambdaworks.redis.cluster.api.sync.RedisAdvancedClusterCommands;

/**
 * Create by zhaoxianghui on 17/7/17.
 */
public class ConnectToRedisCluster {
    public static void main(String[] args) {
        // Syntax: redis://[password@]host[:port]
        RedisClusterClient redisClient = RedisClusterClient.create(RedisURI.create("redis://password@localhost:7379"));
        RedisAdvancedClusterCommands<String, String> connection = redisClient.connect().sync();

        System.out.println("Connected to Redis");

        connection.close();
        redisClient.shutdown();
    }
}
