package com.k.datastructure.queue;

/**
 * 链表实现的队列
 * created by k
 * 2018/6/12
 **/
public class LinkedQueue<T> implements IQueue<T> {
	//队列尾部元素
	private QueueNode<T> tail;
	//队列头部元素
	private QueueNode<T> head;
	//个数
	private int size;

	public LinkedQueue() {
		tail = null;
		head = null;
	}

	@Override
	public int add(T t) {
		if(t ==null){
			throw new NullPointerException();
		}
		if(tail == null){
			QueueNode queueNode = new QueueNode(t);
			queueNode.setData(t);
			tail = queueNode;
			head = tail;
		}else {
			QueueNode queueNode = new QueueNode(t);
			QueueNode oldTail = tail;
			oldTail.setNext(queueNode);
			tail = queueNode;
		}
		size++;
		return 0;
	}

	@Override
	public void enqueue(T t) {
		add(t);
	}

	@Override
	public T dequeue() {
		if(head == null){
			return null;
		}
		QueueNode queueNode = head;
		QueueNode<T> newHead = head.getNext();
		head = newHead;
		Object data = queueNode.getData();
		size--;
		return (T) data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	public static void main(String[] args) {
		LinkedQueue<Integer>linkedQueue = new LinkedQueue<>();
		linkedQueue.add(1);
		linkedQueue.add(2);
		linkedQueue.add(3);
		linkedQueue.add(4);
		linkedQueue.add(21212);

		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.isEmpty());
		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.dequeue());
		System.out.println(linkedQueue.isEmpty());
	}
}
