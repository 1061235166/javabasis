package com.k.jdk.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * void park()：阻塞当前线程，如果调用unpark方法或者当前线程被中断，从能从park()方法中返回
 * void park(Object blocker)：功能同方法1，入参增加一个Object对象，用来记录导致线程阻塞的阻塞对象，方便进行问题排查；
 * void parkNanos(long nanos)：阻塞当前线程，最长不超过nanos纳秒，增加了超时返回的特性；
 * void parkNanos(Object blocker, long nanos)：功能同方法3，入参增加一个Object对象，用来记录导致线程阻塞的阻塞对象，方便进行问题排查；
 * void parkUntil(long deadline)：阻塞当前线程，知道deadline；
 * void parkUntil(Object blocker, long deadline)：功能同方法5，入参增加一个Object对象，用来记录导致线程阻塞的阻塞对象，方便进行问题排查；
 * 作者：你听___
 * 链接：https://www.jianshu.com/p/9677a754cf60
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2019/7/15 14:15
 **/
public class LockSupportTest {

	public static void main(String[] args) {
		test3();
	}

	static Object ob1 = new Object();

	public static void test1(){
		System.out.println(1);
		Thread thread = Thread.currentThread();
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2L);
			} catch (InterruptedException e) {}
			LockSupport.unpark(thread);
		}).start();
		LockSupport.park();
		LockSupport.park(null);
		System.out.println(2);
	}

	public static void test2(){
		Object o = new Object();
		LockSupport.park(o);
	}

	public static void test3(){
		Thread thread = new Thread(() -> {
			LockSupport.park(LockSupportTest.class);
		});
		thread.start();

		new Thread(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LockSupport.unpark(thread);
		}).start();

		LockSupport.park(LockSupportTest.class);
	}
}
