package com.k.jdk.thread;

import java.util.concurrent.*;

/**
 * 创建线程的方式
 * created by k
 * 2018/5/11
 **/
public class CreateThread {

    /**
     * new一个Thread类
     */
    public static void create(){
        new Thread().start();
    }

    /**
     * 重写thread的run方法
     */
    public static void create2(){
        new Thread(){
            @Override
            public void run() {
                //覆盖方法
            }
        }.start();
    }

    /**
     * 用runnable做构造参数
     */
    public static void create3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //覆盖方法
            }
        }).start();
    }

    /**
     * 用lambda创建线程
     */
    public static void create4(){
        new Thread(()-> {}).start();
    }

    /**
     * 使用callable和Future创建线程，并且线程执行后有返回结果，而且是非阻塞的
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void create5() throws ExecutionException, InterruptedException {
        Callable<String>callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return System.currentTimeMillis()+"";
            }
        };
        FutureTask<String>futureTask = new FutureTask(callable);
        Future<?> future = Executors.newCachedThreadPool().submit(futureTask);
        while (!future.isDone());
        //非阻塞的获取线程执行结果
        Object o = future.get();
    }

    /**
     * 使用线程池创建线程
     */
    public static void create6(){
        Executors.newSingleThreadExecutor().execute(()-> System.out.println("执行线程"));
    }
}