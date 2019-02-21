package com.k.mq;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author wyk
 * @date 2019/2/21 14:03
 **/
public class RocketMq {


	/**
	 * 首先启动nameserver,一般来说要改nameserver的jvm设置,调低堆内存大小
	 * 然后启动broker,当broker的配置文件要加nameserver的地址,启动后日志里输出了连接nameserver成功,才算启动成功
	 * 启动命令后还要加入autoCreateTopicEnable=true,要不然发送消息,如果topic不存在会报错
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable{
		sendMessage();
	}

	static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	/**
	 * 一个简单的发送消息demo
	 * @throws MQClientException
	 * @throws RemotingException
	 * @throws InterruptedException
	 * @throws MQBrokerException
	 */
	public static void sendMessage() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
		DefaultMQProducer producer  = new DefaultMQProducer();
		producer.setNamesrvAddr("192.168.205.3:9876");
		producer.setProducerGroup("group1");
		producer.start();

		//
		Message message = new Message();
		//启动命令不加autoCreateTopicEnable=true,如果topic不存在,会报错
		message.setTopic("topic");
		message.setTags("tags");
		message.setBody("body".getBytes());


		producer.send(message, new SendCallback() {
			//发送成功后的回调
			@Override
			public void onSuccess(SendResult sendResult) {
				System.out.println("onSuccess");
				System.out.println(gson.toJson(sendResult));
			}

			@Override
			public void onException(Throwable e) {
				System.out.println("onException");
				System.out.println(gson.toJson(e));
			}
		});

//		producer.shutdown();
	}
}
