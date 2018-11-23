package com.k.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.util.List;

/**
 * created by wyk
 * 2018/10/29
 **/
public class RedisPipeLine {

	public static void main(String[] args) throws IOException {
		Jedis jedis = new Jedis("192.168.2.136");
		Pipeline pipelined = jedis.pipelined();
		pipelined.multi();
		pipelined.set("1","1");//一次性将多个指令放在一个请求里，服务器处理完毕后一起发给客户端，减少了多次请求带来的网络开销
		pipelined.set("2","2");
		Response<List<Object>> exec = pipelined.exec();
		pipelined.close();//必须关闭，否则报错
		List<Object> objects = exec.get();
		System.out.println(objects);

	}

}
