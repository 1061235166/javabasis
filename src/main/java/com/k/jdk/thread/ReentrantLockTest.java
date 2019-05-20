package com.k.jdk.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁测试
 * @author k
 * @date 2019/5/20 11:39
 **/
public class ReentrantLockTest {

	private static ExecutorService executor = Executors.newFixedThreadPool(10);

	private static Lock lock = new ReentrantLock();

	public static void main(String[] args){
		testTryLock();
		executor.execute(()->testTryLock());
		executor.shutdownNow();
	}

	/**
	 *  tryLock:等待超时锁,如果在指定时间内没有获取到锁,就放弃获取
	 * @author k
	 * @date 2019/5/20
	 * @param
	 * @return
	 */
	public static void testTryLock(){
		String name = Thread.currentThread().getName();
		boolean tryLock = false;
		try{
			tryLock= lock.tryLock(1l, TimeUnit.SECONDS);
			if(tryLock){
        		System.out.println(name+"获取锁成功,休眠5秒");
				TimeUnit.SECONDS.sleep(5L);
			}else {
				System.out.println(name+"获取锁失败");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			if(tryLock){
				System.out.println(name+"加锁成功");
			}else {
        		System.out.println(name+"加锁失败");
			}
		}
	}



}
