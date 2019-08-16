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
		sscan();
	}

	private static Jedis getJedis(){
		return new Jedis("localhost");
	}

	/**
	 * 查找userprod开头的key名称，查询第0到第100个
	 */
	public static void scan(){
		Jedis jedis = getJedis();
		ScanParams scanParams = new ScanParams();
		scanParams.match("usersession*");
		scanParams.count(2);//每次查询1个
		String cursor = ScanParams.SCAN_POINTER_START;
		while (true){
			ScanResult<String> scan = jedis.scan(cursor ,scanParams);
			cursor = scan.getStringCursor();
      		System.out.println(cursor);
			//当指针为0的时候说明查询不到其他数据了
      		System.out.println(scan.getResult());
			if(cursor.equals("0")){
				return;
			}
		}
	}

	public static void sscan(){
		Jedis jedis = getJedis();
		String c = ScanParams.SCAN_POINTER_START;
		ScanParams scanParams = new ScanParams();
		scanParams.count(12);
		scanParams.match("*");
		int sum = 0;
		while (true){
			ScanResult<String> sscan = jedis.sscan("set", c, scanParams);
			String stringCursor = sscan.getStringCursor();
//			System.out.println(stringCursor);
			System.out.println(sscan.getResult());
			sum+=sscan.getResult().size();
			c = stringCursor;
			if(stringCursor.equals("0")){
				break;
			}
		}
   		System.out.println("sum:"+sum);
	}

	public static void keys() {
		Jedis jedis = getJedis();
		Set<String> keys = jedis.keys("*");
		System.out.println(keys);
	}
}
