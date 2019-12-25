package com.k.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * rocketmq有序的消费和生产
 * @author k
 * @date 2019/11/6 16:17
 **/
public class RocketMProdConsuDemo {

	static Executor executor = Executors.newFixedThreadPool(2);

	static CountDownLatch downLatch = new CountDownLatch(1);

	public static void main(String[] args){
		executor.execute(new OrderProducer());
		try {
			downLatch.await();
		} catch (InterruptedException e) {

		}
		//executor.execute(new OrderConsumer());
	}

	static class OrderProducer implements Runnable{

		@Override
		public void run() {
			DefaultMQProducer producer = new DefaultMQProducer("order_demo");
			producer.setNamesrvAddr("localhost:9876");
			try {
//				producer.createTopic("","order_topic1",10);
				producer.start();
				for(int i=0;i<10;i++){
					Message message = new Message("hello","tag1",(i+"hello can you consume it?").getBytes());
          			System.out.println(new String(message.getBody()));
					SendResult send = producer.send(message);
          			System.out.println(send.getSendStatus());
          			System.out.println(send.getMsgId());
				}
				downLatch.countDown();

			} catch (MQClientException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RemotingException e) {
				e.printStackTrace();
			} catch (MQBrokerException e) {
				e.printStackTrace();
			}
		}
	}

	static class OrderConsumer implements Runnable{

		@Override
		public void run() {
      		System.out.println("OrderConsumer run");
			DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order_demo2");
			consumer.setNamesrvAddr("localhost:9876");
			try {
				consumer.subscribe("hello","tag1");
				consumer.setMessageListener(new MessageListenerOrderly() {
					@Override
					public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
						for (MessageExt s:msgs){
							System.out.println(new String(s.getBody()));
							String msgId = s.getMsgId();
							System.out.println(msgId);
						}
						System.out.println(msgs.size());
						return ConsumeOrderlyStatus.SUCCESS;
					}
				});
				consumer.start();
			} catch (MQClientException e) {
				e.printStackTrace();
			}
		}
	}


}
