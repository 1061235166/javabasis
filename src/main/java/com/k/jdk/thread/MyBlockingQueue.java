package com.k.jdk.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自己实现的阻塞队列
 * Created by k on 2018/8/30.
 */
public class MyBlockingQueue<T> {

    private ReentrantLock lock = new ReentrantLock();

    private Condition empty = lock.newCondition();

    private Condition full = lock.newCondition();

    private int size;

    private int maxSize;

    private List<T>list = new LinkedList<T>();

    public MyBlockingQueue(int maxSize){
        this.maxSize =maxSize;
    }

    public boolean put(T t) throws InterruptedException {
        lock.lock();
        boolean res;
        try {
            while (list.size() == maxSize){
                full.await();
            }
            res = list.add(t);
            empty.signal();
        }finally {
            lock.unlock();
        }
        return res;
    }

    public T take() throws InterruptedException {
        lock.lock();
        T remove;
        try {
            while (list.isEmpty()){
                empty.await();
            }
            remove = list.remove(list.size() - 1);
            full.signal();
        }finally {
            lock.unlock();
        }
        return remove;
    }

    public static void main(String[] args) {
        MyBlockingQueue<String>myBlockingQueue = new MyBlockingQueue<>(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        executorService.execute(()->{
            for(;;){
                try {
                    boolean put = myBlockingQueue.put("");
                    System.out.println(put);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        executorService2.execute(()->{
//            for(;;){
//                try {
//                    String take = myBlockingQueue.take();
//                    System.out.println("take:"+take);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }
}
