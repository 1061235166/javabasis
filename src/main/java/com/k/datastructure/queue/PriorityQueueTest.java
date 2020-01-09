package com.k.datastructure.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by k on 2020/1/9.
 */
public class PriorityQueueTest {
    //二叉堆的实现
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer>queue=new PriorityQueue<Integer>(comparator);
        queue.add(2);
        queue.add(100);
        queue.add(1);
        queue.add(3);
        queue.add(30);
        queue.add(-10);
        System.out.println();
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
        System.out.println("===");
        while (!queue.isEmpty()){
            Integer peek = queue.poll();
            System.out.println(peek);
        }

    }
}
