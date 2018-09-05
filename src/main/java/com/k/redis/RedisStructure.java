package com.k.redis;

import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * redis数据结构
 * redis的数据结一共有5中分别是：string、list、hash、set和zset。
 * created by wyk
 * redis基础数据：https://juejin.im/post/5b53ee7e5188251aaa2d2e16
 * 2018/8/9
 **/
public class RedisStructure {
	static final String host = "192.168.2.128";
	static final int port = 6379;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		list();
	}

	public static void string(){
		Jedis jedis = new Jedis(host,port);
		jedis.connect();;
		String s = jedis.get("1");
		System.out.println(s);
		jedis.set("1","12");
		jedis.close();
	}

	public static void list() throws IOException, ClassNotFoundException {
		Jedis jedis = new Jedis(host,port);
		Long lpush = jedis.lpush("asd".getBytes(), "123".getBytes(), "325".getBytes());
		System.out.println(lpush);
		System.out.println(jedis.lpop("asd"));

		Long asd = jedis.llen("asd");
		System.out.println(asd);

		String asd1 = jedis.lindex("asd", 8);
		System.out.println(asd1);

		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
		List<Short>list = new ArrayList<>();
		list.add(new Short("21"));
		list.add(new Short("21789"));
		objectOutputStream.writeObject(list);
		jedis.lpush("objects".getBytes(),arrayOutputStream.toByteArray());

		byte[] lpop = jedis.lpop("objects".getBytes());

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(lpop);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		Object o = objectInputStream.readObject();
		System.out.println(o.getClass());

	}
}
