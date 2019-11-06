package com.k.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.Executors;

/**
 * @author k
 * @date 2019/11/6 15:08
 **/
public class RocketMqProducer implements Runnable{

	//生产者
	public static void main(String[] args) {
		RocketMqProducer producer = new RocketMqProducer();
		Executors.newFixedThreadPool(1).execute(producer);
	}

	@Override
	public void run() {
		DefaultMQProducer producer = new DefaultMQProducer("test-group");
		producer.setNamesrvAddr("localhost:9876");
		try {
			producer.start();
			//开启broker的时候必须设置为createTopic为true,否则会报错
			Message message = new Message("topci1","tag1","11","hello rocketmq".getBytes());
			//同步发送消息
//			SendResult send = producer.send(message);
//			SendStatus sendStatus = send.getSendStatus();
//      		System.out.println(sendStatus);
			//异步发送消息
			producer.send(message, new SendCallback() {
				@Override
				public void onSuccess(SendResult sendResult) {
					System.out.println(sendResult);
				}

				@Override
				public void onException(Throwable e) {
					System.out.println(e==null);
					System.out.println(e);
				}
			});


			producer.shutdown();
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RemotingException e) {
			e.printStackTrace();
		} /*catch (MQBrokerException e) {
			e.printStackTrace();
		}*/
	}
}
