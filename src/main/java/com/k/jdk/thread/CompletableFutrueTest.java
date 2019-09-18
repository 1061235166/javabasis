package com.k.jdk.thread;


import com.google.common.collect.Maps;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by k on 2018/11/18.
 * http://www.importnew.com/10815.html  总结的优点和不足
 *
 */
public class CompletableFutrueTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        test1();
//        test2();
		test4();
    }

    public static void test1() throws InterruptedException, ExecutionException, TimeoutException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> atomicInteger.addAndGet(1));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> atomicInteger.addAndGet(3));
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> atomicInteger.addAndGet(4));
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
            try {
                //任务完成时间5秒
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.addAndGet(100);
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1,future2,future3,future4);
        //阻塞住，当所有任务都完成后返回。设置3秒超时，抛出异常
        voidCompletableFuture.get(3l,TimeUnit.SECONDS);
        //获取最后结果
        System.out.println(atomicInteger.get());
    }

    public static void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture();

        new Thread(()->{
            try {
                //阻塞三秒之后完成任务
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean complete = completableFuture.complete("11111");
        }).start();
        String s = completableFuture.get();
        System.out.println(s);
    }

    public static void test3(){
//    System.out.println(1);
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 1;
		});
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
			return 2;
		});

		CompletableFuture.allOf(future, future2);
		//join,当任务完成后获取结果,不会抛出检查性异常
    	System.out.println(future.join());
    	System.out.println(future2.join());
	}

	public static void test4(){
		CompletableFuture<String> stringCompletableFuture = CompletableFuture.completedFuture("1111");
    	System.out.println(stringCompletableFuture.join());
		//每个人物按照步骤进行,上一个完了才进行下一个
		CompletableFuture.runAsync(
				() -> {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(1);
				})
				.thenRun(() -> {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(2);
				})
				.thenRun(() -> {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(3);
				}).join();

		//对supplyasync返回值做判断
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException();
		})
		.exceptionally(ex -> "errorResultA")
		.thenApply(resultA -> resultA + " resultB")
		.thenApply(resultB -> resultB + " resultC")
		.thenApply(resultC -> resultC + " resultD");
    	System.out.println(future.join());
	}
}
