package com.k.datastructure.queue;

/**
 * 设计连接：https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/865/
 * 设计一个循环队列
 * 题目连接：https://leetcode.com/problems/design-circular-queue/
 * 特征：head和tail的下标只会从左右往右发展
 * 以下是自己的做法，虽然是错误的
 * Created by k on 2019/1/7.
 */
public class 循环队列 {

    private int size;

    private int[]array;

    private int head,tail=-1;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public 循环队列(int k) {
        size=0;
        array=new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //数组为空
        if(isEmpty()){
            head = 0;
            tail= 0;
            array[0]=value;
            return true;
        }
        if(isFull()){
            return false;
        }
        if(tail>=size-1){
            tail=0;
            array[tail]=value;
        }else {
            array[tail++]=value;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head==0){
            head = size-1;
            array[0]=0;
        }else {
            array[head--]=0;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return 0;
        }
        return array[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return 0;
        }
        return array[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head==-1 && tail==-1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return tail+1 == head || tail-1==head;
    }
}
//网上的解法
class MyCircularQueue {
    final int[] a;
    int front, rear = -1, len = 0;

    public MyCircularQueue(int k) { a = new int[k];}

    public boolean enQueue(int val) {
        if (!isFull()) {
            rear = (rear + 1) % a.length;
            a[rear] = val;
            len++;
            return true;
        } else return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % a.length;
            len--;
            return true;
        } else return false;
    }

    public int Front() { return isEmpty() ? -1 : a[front];}

    public int Rear() {return isEmpty() ? -1 : a[rear];}

    public boolean isEmpty() { return len == 0;}

    public boolean isFull() { return len == a.length;}
}