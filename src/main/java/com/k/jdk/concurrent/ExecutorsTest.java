package com.k.jdk.concurrent;

import java.util.concurrent.*;

/**
 * 线程池
 * created by wyk
 * 2018/9/13
 **/
public class ExecutorsTest {

	public static void main(String[] args) {
		debug();
	}

	public static void t1(){
		//创建一个10个线程的线程池
		//内部构造方法有一个LinkedBlockingQueue，他最多能存n个任务，核心池大小n
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		//默认是ThreadPoolExecutor.class类型的
		System.out.println(executorService.getClass());

	}

	static void debug(){
		//被创建的线程会不断使用while循环从workerQueue里取任务并执行,没有的话会一直阻塞
		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		executorService.execute(()->{
			System.out.println(1);
		});
		executorService.execute(()->{
			System.out.println(2);
		});


	}
}
