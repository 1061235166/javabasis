package com.k.并发;

import java.util.concurrent.*;

/**
 * @author wyk
 * @date 2019/2/27 09:32
 **/
public class JUCTest {


	public static void main(String[] args) {
		cyclicBarriarTest();
	}

	/**
	 * countdownlatch,倒计时工具，在计数为0时释放主线程的阻塞
	 */
	static void countdownlatch(){
		CountDownLatch countDownLatch = new CountDownLatch(4);
		ExecutorService service = Executors.newFixedThreadPool(1);


		service.execute(()->{
			for(int i=0;i<3;i++){
				countDownLatch.countDown();
				long count = countDownLatch.getCount();
				System.out.println(count);
				try {
					TimeUnit.SECONDS.sleep(2l);
				} catch (InterruptedException e) {}
			}
		});

		System.out.println("await");
				//开启屏障
		try {
			countDownLatch.await(10l,TimeUnit.SECONDS);
		} catch (InterruptedException e) {}
		System.out.println("await notify");



		System.out.println("countdown");

		service.shutdown();
	}

	/**
	 * semaphore,控制某个时间段有多少线程访问
	 */
	static void SemaphoreTest(){
		Semaphore semaphore = new Semaphore(5);
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i=0;i<30;i++){
			int a= i;
			service.execute(()->{
				try {
					semaphore.acquire();
					System.out.println("开始第"+a+"个任务");
					TimeUnit.SECONDS.sleep(5);
					System.out.println("结束第"+a+"个任务");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				semaphore.release();
			});
		}
	}


	/**
	 * 等待await（达到最大值时）释放所有await的线程
	 */
	static void cyclicBarriarTest(){
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    int await = cyclicBarrier.await();
                    System.out.println(await);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        try {
            Thread.sleep(3000);
            int await = cyclicBarrier.await();
            System.out.println(await);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
