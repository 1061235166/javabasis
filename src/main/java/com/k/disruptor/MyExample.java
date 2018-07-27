package com.k.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 基本用法
 * created by k
 * 2018/7/19
 **/
public class MyExample {

	public static void main(String[] args) {
		ThreadFactory helloName = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r, "helloName");
			}
		};
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		};

		Disruptor disruptor = new Disruptor(new MyExampleEventFactory(),2,threadFactory, ProducerType.MULTI, new BlockingWaitStrategy());


		disruptor.handleEventsWith(new MyExampleEventHandler());

		RingBuffer<PlayEvent> ringBuffer = disruptor.start();

		for(int i=0;i<100000;i++){
//			long sequence = ringBuffer.next();
//			PlayEvent playEvent = ringBuffer.get(sequence);
			PlayEvent playEvent =new PlayEvent();
			playEvent.setName(UUID.randomUUID().toString());
			ringBuffer.publishEvent(new MyExampleEventTranslator(),playEvent.getName());
		}

		executorService.shutdown();
		disruptor.shutdown();
	}
}
