package com.k.jdk.thread;

import sun.nio.cs.ext.MacThai;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by k on 2019/5/26.
 */
public class ThreadInterview {

    public static void main(String[] args) {
        printChars();
    }

    /**
     * 两个线程，依次打印a-z 26个英文单词，
     */
    public static void printChars(){

        String[] str = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
                "u","v","w","x","y","z"};
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        int index=0;

        AtomicInteger integer = new AtomicInteger(0);


        Thread a = new Thread(()->{
            boolean s=false;
            lock.lock();
            try {
                for(int i=0;i<str.length;i++){
                    if(!s && integer.getAndAdd(1)%2==0){
                        System.out.println(str[i]);
                    }else {
                        s=true;
                    }

                }
            } finally {
                lock.unlock();
            }
        });
        Thread b = new Thread(()->{
            boolean s=false;
            lock.lock();
            try {
                for(int i=0;i<str.length;i++){
                    if(s && integer.getAndAdd(1)%2!=0){
                        System.out.println(str[i]);
                    }else {
                        s=false;
                    }
                }
            } finally {
                lock.unlock();
            }
        });

        a.start();
        b.start();
    }
}
