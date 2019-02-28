package com.k.并发;

import java.util.concurrent.*;

/**
 * @author wyk
 * @date 2019/2/27 09:32
 **/
public class JUCTest {


	public static void main(String[] args) {
		countdownlatch();
	}

	static void countdownlatch(){
		CountDownLatch countDownLatch = new CountDownLatch(4);
		ExecutorService service = Executors.newFixedThreadPool(1);


		service.execute(()->{
			for(int i=0;i<3;i++){
				countDownLatch.countDown();
				long count = countDownLatch.getCount();
				System.out.println(count);
				try {
					TimeUnit.SECONDS.sleep(2l);
				} catch (InterruptedException e) {}
			}
		});

		System.out.println("await");
				//开启屏障
		try {
			countDownLatch.await(10l,TimeUnit.SECONDS);
		} catch (InterruptedException e) {}
		System.out.println("await notify");



		System.out.println("countdown");

		service.shutdown();
	}

}
