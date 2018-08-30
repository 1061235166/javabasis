package com.k.jdk.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
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

    }
}
