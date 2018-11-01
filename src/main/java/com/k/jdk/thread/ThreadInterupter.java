package com.k.jdk.thread;

/**
 * 线程中断
 * created by wyk
 * 2018/11/1
 **/
public class ThreadInterupter {

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().setName("interrupter");
		for(int i=0;i<100;i++){
//			Thread.sleep(200);
			System.out.println(Thread.currentThread().getName()+"_"+i);
			if(i==9){
				System.out.println("准备中断");
				Thread.currentThread().interrupt();
			}
			//就算被中断，其实线程也能够运行
			System.out.println("是否中断："+Thread.currentThread().isInterrupted());
		}
	}
}
