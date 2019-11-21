package com.k.datastructure.queue;

/**
 * TODO
 * created by k
 * 2018/6/12
 **/
public class ArrayQueue<T> implements IQueue<T> {
	//数组
	private T [] array;
	//尾部下标
	private int tailIndex;
	//头部下标
	private int headIndex;

	private int size;

	public ArrayQueue() {
		array = (T[]) new Object[10];
	}

	@Override
	public int add(T t) {
		int length = array.length;
		if(length == 0){
			//最后一个元素
			array[length-1] = t;
			headIndex = length-1;
			tailIndex = length -1 ;
		}

		size++;
		return 0;
	}

	@Override
	public void enqueue(T t) {

	}

	@Override
	public T dequeue() {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
}
