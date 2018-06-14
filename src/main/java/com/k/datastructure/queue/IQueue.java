package com.k.datastructure.queue;

/**
 * 队列
 * created by k
 * 2018/6/12
 **/
public interface IQueue<T> {
	/**
	 * 添加一个元素
	 * @param t
	 * @return
	 */
	int add(T t);

	/**
	 * 入队
	 * @param t
	 */
	void enqueue(T t);

	/**
	 * 出队
	 * @return
	 */
	T dequeue();

	/**
	 * 个数
	 * @return
	 */
	int size();

	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty();

}
