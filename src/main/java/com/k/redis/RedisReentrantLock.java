package com.k.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Random;

/**
 * 使用redis
 * created by k
 * 2018/8/10
 **/
public class RedisReentrantLock {

	private Map<String,Integer>counts;

	private final String host = "192.168.2.128";

	private final Integer port=6379;

	private final String lockName = "redis_lock";

	private Random random = new Random();

	private Jedis jedis = new Jedis(host,port);

	public boolean lock(){
		String v = random.nextInt(10000)+"";
		String s = jedis.set(lockName, v, "nx", "ex", 1000);

		return s!=null;
	}

	/**
	 * 非原子性操作
	 * @param value
	 */
	public void unLock(String value){
		String v = jedis.get(lockName);
		if(v!=null && v.equals(value)){
			jedis.del(lockName);
		}
	}

}
