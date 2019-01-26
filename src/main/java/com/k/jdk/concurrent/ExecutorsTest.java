package com.k.jdk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * 线程池
 * created by wyk
 * 2018/9/13
 **/
public class ExecutorsTest {

	public static void main(String[] args) {
		t1();
	}

	public static void t1(){
		//创建一个10个线程的线程池
		//内部构造方法有一个LinkedBlockingQueue，他最多能存n个任务，核心池大小n
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		//默认是ThreadPoolExecutor.class类型的
		System.out.println(executorService.getClass());

	}
}
