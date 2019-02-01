package com.k.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RHyperLogLog;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Random;

/**
 * redisson基本操作
 * Created by k on 2019/1/8.
 */
public class BaseOperation {
    private static RedissonClient redissonClient = Redisson.create();
    public static void main(String[] args) {
        RedissonClient redissonClient = create();
        Config config = redissonClient.getConfig();
        System.out.println(config);
        int threads = config.getThreads();
        System.out.println(threads);

        System.out.println(redissonClient.isShutdown());

        RHyperLogLog<Integer> number = redissonClient.getHyperLogLog("number");

        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            number.add(i);
        }
        System.out.println(number.count());
        redissonClient.shutdown();
        System.out.println(redissonClient.isShutdown());
    }

    private static RedissonClient create(){
        RedissonClient redissonClient = Redisson.create();
        return redissonClient;
    }

    public static void stringOper(){
        RLock lock = redissonClient.getLock("123");

    }
}
