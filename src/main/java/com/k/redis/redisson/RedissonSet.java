package com.k.redis.redisson;

import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;

/**
 * @author wyk
 * @date 2019/11/5 17:36
 **/
public class RedissonSet {
	public static void main(String[] args) {

	}

	static void set(){
		RedissonClient client = BaseOperation.create();
		RSet<Object> set = client.getSet("set");

	}

}
