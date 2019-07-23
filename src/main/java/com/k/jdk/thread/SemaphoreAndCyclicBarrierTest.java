package com.k.jdk.thread;

import sun.nio.cs.ext.MacThai;

import java.util.concurrent.*;

/**
 * Created by k on 2019/7/23.
 */
public class SemaphoreAndCyclicBarrierTest {

    public static void main(String[] args) {
        barrierTest();
    }

    /**
     * tryAcquire过后，信号值减一，如果信号值为0，tryAcquire会一直失败，除非有tryAcquire成功后的线程调用了
     */
    static void test1() {
        Semaphore semaphore = new Semaphore(5);
        Runnable runnable = ()->{
            boolean b = semaphore.tryAcquire();
            try {
                if(b){
                    System.out.println(b);
               }else {
                    System.out.println("tryAcquire失败");
                }
            }finally {
//                semaphore.release();
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(10);
        for(;;){
            service.execute(runnable);
        }
    }

    /**
     * 当调用barrier的await次数到达parties的值，await才会取消阻塞
     */
    static void barrierTest(){
        CyclicBarrier barrier = new CyclicBarrier(100);
        Runnable runnable = ()->{
            try {
                System.out.println("wait"+barrier.getNumberWaiting());
                barrier.await();
                Thread.sleep(2000);
                System.out.println("relase"+barrier.getNumberWaiting());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
//        for(;;){
//            System.out.println(barrier.getNumberWaiting());
//        }
    }
}
