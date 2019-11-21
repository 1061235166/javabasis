package com.k.redis;

import com.k.redis.redisson.BaseOperation;
import org.apache.commons.lang3.Range;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * redis 列表的阻塞操作,从列表左右两侧取出数据
 * @author k
 * @date 2019/10/28 17:09
 **/
public class RedisBlockingOp {

	public static void main(String[] args) throws InterruptedException {
//		zsetblocking();
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(1);
		blockingQueue.add(11);
		boolean offer = blockingQueue.offer(10, 2l, TimeUnit.SECONDS);
    System.out.println(offer);
		System.out.println(111);
	}

	static void jedisblocking(){Jedis jedis = new Jedis();
		//尝试从列表左侧取出并删除第一个元素,超时时间10秒
		List<String> bb = jedis.blpop(10,"bb");
		System.out.println(bb);

		//尝试从列表右侧取出并删除第一个元素,超时时间10秒
		List<String> aa = jedis.brpop(10, "aa");
		System.out.println(aa);
	}

	/**
	 * 使用redisson
	 * @throws InterruptedException
	 */
	static void redissonblocking() throws InterruptedException {
		Config config = new Config();
		//必须设置为字符串编码解码器
		config.setCodec(StringCodec.INSTANCE);
		SingleServerConfig singleServerConfig = config.useSingleServer();
		singleServerConfig.setAddress("redis://localhost:6379");
		RedissonClient client = Redisson.create(config);
		Codec codec = client.getConfig().getCodec();
   		System.out.println(codec.getClass());
		RBlockingQueue<String> queue = client.getBlockingQueue("bbb");
		for(int i=0;i<5;i++){
			queue.put(i+"");
		}
		String poll = queue.poll();
    	System.out.println(poll);
		poll = queue.poll();
		System.out.println(poll);
		poll = queue.poll();
		System.out.println(poll);
		poll = queue.poll();
		System.out.println(poll);
		poll = queue.poll();
		System.out.println(poll);
		//前5个可以被正常取出,此时队列为空,需要在5秒内往队列里添加一个元素,否则返回空
		poll = queue.poll(15, TimeUnit.SECONDS);
		System.out.println(poll);
		client.shutdown();
	}

	static void zsetblocking(){
		RedissonClient client = BaseOperation.create();
		RBitSet bit = client.getBitSet("bit");
		bit.set(0l,true);
		bit.set(1l,true);
		bit.set(2l,false);
		RHyperLogLog<Object> log = client.getHyperLogLog("hy");
		Range<Integer> between = Range.<Integer>between(0, 1000);

	}
}
