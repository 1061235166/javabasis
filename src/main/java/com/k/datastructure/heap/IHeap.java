package com.k.datastructure.heap;

/**
 * Created by k on 2018/5/29.
 */
public interface IHeap<T> {

    IHeap create(int size);

    boolean isFull(IHeap iHeap);

    void insert(IHeap heap,T ele);

    /**
     * 堆是否为空
     * @param iHeap
     * @return
     */
    boolean isEmpty(IHeap iHeap);

    /**
     * 删除最大或最小元素
     * @param iHeap
     */
    void deleteRoot(IHeap iHeap);
}
