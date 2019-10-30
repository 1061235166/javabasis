package com.k.jdk.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 几种线程按照顺序执行的方式
 * @author k
 * @date 2019/10/25 14:06
 **/
public class ThreadRunByOrder {

	public static void main(String[] args) {
		order5();
	}

	/**
	 * 使用join
	 */
	static void order1(){
		Thread t1 = newThread(() -> {
			int i = new Random().nextInt(1000);
			try {
				Thread.sleep(i+0l);
				println("休眠了"+i+"毫秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			println("线程1");
		});
		Thread t2 = newThread(() -> {
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			println("线程2肯定在线程1之后执行");
		});
		t1.start();
		t2.start();

	}

	static void order2(){
		Object o1 = new Object();
		Object o2 = new Object();
		Thread t1 = newThread(() -> {
			synchronized (o1){

			}
		});
		Thread t2 = newThread(() -> {
			synchronized (o1){

			}
		});
		Thread t3 = newThread(() -> {
			synchronized (o1){

			}
		});

	}

	/**
	 * 只有1个线程能够活跃的线程池
	 * 按顺序入队,按顺序被worker取出并执行
	 */
	static void order3(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(()->println("线程1"));
		executorService.execute(()->println("线程2"));
		executorService.execute(()->println("线程3"));
		executorService.execute(()->println("线程4"));
		executorService.execute(()->println("线程5"));
		executorService.shutdown();
	}

	/**
	 * 两个countdownlatch限制线程顺序
	 */
	static void order4(){
		CountDownLatch c1 = new CountDownLatch(1);
		CountDownLatch c2 = new CountDownLatch(1);
		Thread t1 = newThread(() -> {
			println("线程1");
			c1.countDown();
		});
		Thread t2 = newThread(() -> {
			try {
				c1.await();
			} catch (InterruptedException e) {}
			println("线程2");
			c2.countDown();
		});
		Thread t3 = newThread(() -> {
			try {
				c2.await();
			} catch (InterruptedException e) {}
			println("线程3");
		});

		t1.start();
		t2.start();
		t3.start();
	}
	static boolean r1 = false;
	static boolean r2 = false;
	/**
	 * 用condition完成
	 */
	static void order5(){
		ReentrantLock lock = new ReentrantLock();
		Condition c1 = lock.newCondition();
		Condition c2 = lock.newCondition();

		Thread t1 = newThread(() -> {
			try{
				lock.lock();
				println("线程1");
				r1 = true;
				c1.signal();
			}finally{
				lock.unlock();
			}

		});
		Thread t2 = newThread(() -> {
			try{
				lock.lock();
				c1.await();
				if(r1){
					println("线程2");
				}
				r2 = true;
				c2.signal();
			}catch (Exception e){

			}finally{
				lock.unlock();
			}


		});
		Thread t3 = newThread(() -> {
			try{
				lock.lock();
				c2.await();
				if(r2){
					println("线程3");
				}
			}catch (Exception e){

			}finally{
				lock.unlock();
			}

		});
		t1.start();
		t2.start();
		t3.start();

	}

	static Thread newThread(Runnable r){
		return new Thread(r);
	}

	static void println(String msg){
    	System.out.println(msg);
	}

}
