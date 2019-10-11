package com.k.并发;

/**
 * 死锁
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
