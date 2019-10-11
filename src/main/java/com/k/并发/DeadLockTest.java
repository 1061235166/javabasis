package com.k.并发;

/**
 * 死锁
 * 无限循环,会出现死锁,lock1等待lock2释放同时lock2等待lock1释放
 * @author k
 * @date 2019/10/11 16:39
 **/
public class DeadLockTest {

  public static void main(String[] args) {
	  new Thread(new JUCLock1()).start();
	  new Thread(new JUCLock2()).start();
  }

	static Object lock1 = new Object();

	static Object lock2 = new Object();

	static class JUCLock1 implements Runnable{

		@Override
		public void run() {
			System.out.println("启动JUC1");
			while (true){
				synchronized (lock1){
					synchronized (lock2){
            			System.out.println("hello1");
					}
				}
			}
		}
	}

	static class JUCLock2 implements Runnable{

		@Override
		public void run() {
			System.out.println("启动JUC2");
			while (true){
				synchronized (lock2){
					synchronized (lock1){
						System.out.println("hello2");
					}
				}
			}
		}
	}

}
