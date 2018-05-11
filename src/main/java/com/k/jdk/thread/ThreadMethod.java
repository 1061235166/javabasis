package com.k.jdk.thread;

/**
 *
 * yeild方法会放弃时间片，让别的线程有机会执行
 * created by wyk
 * 2018/5/11
 **/
public class ThreadMethod {
    public static void yeild(){
        new Thread(()->{
            System.out.println("1 s");
            //此处该线程会出让cpu时间片让其他线程执行，等待本线程再次获取cpu时间片后
            Thread.yield();
            System.out.println("1 c");
        }).start();
        new Thread(()->{
            System.out.println("2 s");
            System.out.println("2 c");
        }).start();
    }

    public static void main(String[] args) {
        yeild();
    }
}
