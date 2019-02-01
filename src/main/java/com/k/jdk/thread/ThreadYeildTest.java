package com.k.jdk.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by wyk
 * 2018/11/2
 **/
public class ThreadYeildTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread.yield();
//		ExecutorService executorService = Executors.newFixedThreadPool(1);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1l, TimeUnit.SECONDS, new ArrayBlockingQueue(1));
		threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

			}
		});
		AtomicInteger atomicInteger = new AtomicInteger(0);
		for(;;){
			threadPoolExecutor.execute(()->{
				String name = Thread.currentThread().getName();
//				if(atomicInteger.get()%10 ==0){
					//把cpu时间片让出，让线程重新竞争时间片，通常获取时间片的还是刚才调用yield的线程
					Thread.yield();
					String afterName = Thread.currentThread().getName();
//					System.out.println(name+"当前线程yield");
					//如果之后线程的名称和之前不一样，说明yield之后，时间片被不同的线程获取了
					if(!afterName.equals(name)){
						System.out.println("after为"+afterName);
						System.out.println("之前为"+name);
					}
//				}
//				System.out.println(name);
				int i = atomicInteger.incrementAndGet();
				System.out.println(i);
			});
		}
//		System.out.println(Thread.currentThread().getName());
	}

}
