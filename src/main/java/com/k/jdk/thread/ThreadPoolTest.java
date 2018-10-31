package com.k.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by wyk
 * 2018/10/31
 **/
public class ThreadPoolTest {

	public static void main(String[] args) {
		userThreadPool();
	}

	public static void userThreadPool(){
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//通过打印线程名和id说明了一直是这两个线程在工作
		for(;;){
			executorService.execute(()->{
				String name = Thread.currentThread().getName();
				long id = Thread.currentThread().getId();
				System.out.println(name+"_"+id);
			});
		}

	}
}
