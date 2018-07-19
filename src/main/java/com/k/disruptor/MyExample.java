package com.k.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by wyk
 * 2018/7/19
 **/
public class MyExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Disruptor disruptor = new Disruptor(()->{
			return new PlayEvent();
		},2<<100,executorService);

		EventHandler<PlayEvent>eventEventHandler = new EventHandler<PlayEvent>() {
			@Override
			public void onEvent(PlayEvent playEvent, long l, boolean b) throws Exception {
				System.out.println(playEvent.getName());
				System.out.println(l);
				System.out.println(b);
			}
		};

		disruptor.handleEventsWith(eventEventHandler);


		RingBuffer<PlayEvent> ringBuffer = disruptor.start();

		for(int i=0;i<100000;i++){
			long sequence = ringBuffer.next();
			PlayEvent playEvent = ringBuffer.get(sequence);
			playEvent.setName(UUID.randomUUID().toString());
			ringBuffer.publish(sequence);

		}
		executorService.shutdown();
		disruptor.shutdown();
	}
}
