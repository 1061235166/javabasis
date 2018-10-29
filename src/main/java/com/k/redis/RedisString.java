package com.k.redis;
 
import redis.clients.jedis.Jedis;


/**
 * redis字符串
 * created by wyk
 * 2018/10/25
 **/
public class RedisString {

	public static void main(String[] args)  {
		bitSetAndGet();
	}

	public static void setAndGet(){
		Jedis jedis = new Jedis("192.168.2.128",6379);
		//存字符串，如果key已存在会覆盖
		jedis.set("1","2");
		//取字符串
		jedis.get("1");


	}

	/**
	 * bi类型就是从string里取一个字节
	 */
	public static void bitSetAndGet(){
		//内网redis 地址
		Jedis jedis = new Jedis("192.168.2.128",6379);
		//记录一个人的签到状况
		String userId = "102001";
		//用户本月9天的签到记录，1为签到，0为未签到
		jedis.setbit(userId,0,"1");
		jedis.setbit(userId,1,"0");
		jedis.setbit(userId,2,"0");
		jedis.setbit(userId,3,"1");
		jedis.setbit(userId,4,"0");
		jedis.setbit(userId,5,"1");
		jedis.setbit(userId,6,"0");
		jedis.setbit(userId,7,"1");
		jedis.setbit(userId,8,"1");

		//本月第二天是否签到，否
		System.out.println(jedis.getbit(userId,1));
		//本月底8天是否签到，是
		System.out.println(jedis.getbit(userId,7));

		//获取某个字符串位数为1的个数
		Long bitcount = jedis.bitcount(userId);
		System.out.println(bitcount);

		//获取某个字符串n-m位数为1的个数、
		Long bitcount1 = jedis.bitcount(userId, 8, 16);
		System.out.println(bitcount1);


	}
}
