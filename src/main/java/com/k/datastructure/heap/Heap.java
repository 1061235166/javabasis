package com.k.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆（最大堆和最小堆）是一个完全二叉树
 * 最大堆：一个堆节点的值比他的儿子节点值都要大，并且根节点的值是堆里最大的
 * 最小堆：一个堆节点的值比他的儿子节点值都要小，并且根节点的值是堆里最小的
 * Created by k on 2018/5/27.
 */
public class Heap<T extends Comparable<T>> {
    private List<T>list ;

    public Heap(List<T> list) {
        this.list = list;
    }

    public Heap(int size){
        this.list= new ArrayList<>(size);
    }

    public void insert(T data){
        int size = list.size()+1;

    }

    public void remove(T data){

    }

    public void get(){

    }
}
