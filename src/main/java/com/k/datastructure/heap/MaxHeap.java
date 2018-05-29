package com.k.datastructure.heap;



/**
 * Created by k on 2018/5/27.
 */
public class MaxHeap implements IHeap {

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap(10);

    }

    @Override
    public IHeap create(int size) {
        return null;
    }

    @Override
    public boolean isFull(IHeap iHeap) {
        return false;
    }

    @Override
    public void insert(IHeap heap, Object ele) {

    }

    @Override
    public boolean isEmpty(IHeap iHeap) {
        return false;
    }

    @Override
    public void deleteRoot(IHeap iHeap) {

    }
}
