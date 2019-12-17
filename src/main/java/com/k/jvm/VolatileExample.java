package com.k.jvm;

/**
 * volatile例子
 * https://mp.weixin.qq.com/s?__biz=MzIxMTE0ODU5NQ==&mid=2650237211&idx=1&sn=5764f2081f19cad04f24de9b2b23f900&scene=19#wechat_redirect
 * 果第一个操作为volatile读，则不管第二个操作是啥，都不能重排序。这个操作确保volatile读之后的操作不会被编译器重排序到volatile读之前；
 当第二个操作为volatile写是，则不管第一个操作是啥，都不能重排序。这个操作确保volatile写之前的操作不会被编译器重排序到volatile写之后；
 当第一个操作volatile写，第二操作为volatile读时，不能重排序。
 volatile的底层实现是通过插入内存屏障，但是对于编译器来说，发现一个最优布置来最小化插入内存屏障的总数几乎是不可能的，所以，JMM采用了保守策略。如下：
 在每一个volatile写操作前面插入一个StoreStore屏障
 在每一个volatile写操作后面插入一个StoreLoad屏障
 在每一个volatile读操作后面插入一个LoadLoad屏障
 在每一个volatile读操作后面插入一个LoadStore屏障
 * @date 2019/12/4 16:28
 **/
public class VolatileExample {
	int i = 0;
	volatile boolean flag = false;
	public void write(){
		i = 2;
		flag = true;
	}

	public void read(){
		if(flag){
			System.out.println("---i = " + i);
		}
	}

	public static void main(String[] args) {
		VolatileExample volatileExample = new VolatileExample();
		new Thread(volatileExample::read).start();
		new Thread(volatileExample::write).start();
	}
}
