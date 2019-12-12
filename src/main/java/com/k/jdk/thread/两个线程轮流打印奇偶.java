package com.k.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2019/12/12 16:07
 **/
public class 两个线程轮流打印奇偶 {
	public static void main(String[] args) {
		method2();
	}
	static volatile Object obj = new Object();
	static volatile int num=0;
	static void method1(){
		new Thread(()->{
			synchronized (obj){
				while (true){
					if(num%2==0){
						System.out.println("偶数"+num);
						num++;
					}
					try {
						obj.notify();
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(()->{
			synchronized (obj){
				while (true){
					if(num%2!=0){
						System.out.println("奇数"+num);
						num++;
					}
					try {
						obj.notify();
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	static volatile boolean isOdd=true;

	static AtomicInteger integer = new AtomicInteger();

	static void method2(){
		new Thread(()->{
			while (true){
				if(isOdd){
					int andIncrement = integer.getAndIncrement();
					System.out.println("偶数"+andIncrement);
					isOdd=false;
				}
			}
		}).start();
		new Thread(()->{
			while (true){
				if(!isOdd){
					int andIncrement = integer.getAndIncrement();
					System.out.println("奇数"+andIncrement);
					isOdd=true;
				}
			}
		}).start();
	}
}
