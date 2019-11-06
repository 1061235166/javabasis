package com.k.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author wyk
 * @date 2019/11/6 15:40
 **/
public class RocketMqConsumer implements Runnable {


	@Override
	public void run() {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test-group");
		try {
			consumer.setNamesrvAddr("localhost:9876");


			consumer.subscribe("topic1","*");

			consumer.registerMessageListener(new MessageListenerOrderly() {

				@Override
				public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
					msgs.stream().forEach((msg)->{
						byte[] body = msg.getBody();
						System.out.println(new String(body));

					});
					System.out.println(context);
					return ConsumeOrderlyStatus.SUCCESS;
				}
			});

			consumer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Executors.newFixedThreadPool(1).execute(new RocketMqConsumer());
	}
}
