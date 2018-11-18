package com.k.jdk.thread;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by k on 2018/11/18.
 */
public class CompletableFutrueTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        test1();
        test2();
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

}
