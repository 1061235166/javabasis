package com.k.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.List;
import java.util.Set;

/**
 * created by wyk
 * 2018/10/29
 **/
public class RedisOperation {

	public static void main(String[] args) {
		scan();
		System.out.println("==================================");
		keys();
	}

	private static Jedis getJedis(){
		return new Jedis("192.168.2.136");
	}

	/**
	 * 查找userprod开头的key名称，查询第0到第100个
	 */
	public static void scan(){
		Jedis jedis = getJedis();
		ScanParams scanParams = new ScanParams();
		scanParams.match("userprod*");
		scanParams.count(100);
		ScanResult<String> scan = jedis.scan("0", scanParams);
		List<String> result = scan.getResult();
		System.out.println(result);
	}

	public static void keys() {
		Jedis jedis = getJedis();
		Set<String> keys = jedis.keys("*");
		System.out.println(keys);
	}
}
