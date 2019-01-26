package com.k.算法;

/**
 * 斐波那契数列
 * 1,1,2,3,5,8,13,21,34....
 * 第一和第二个数字为1，接下来每位数字是他前一个和前两个数字之和，求第 n 位数字是什么
 * created by wyk
 * 2018/11/28 16:01
 **/
public class FibonacciSequence {

	public static int fibonacci(int n){// n 为第几位数字
		if(n==1 || n==2){
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}

	public static int finbonacciLoop(int n){
		int i = 0;
		int r = 0;
		int first = 1;
		int secend = 1;
		if(n==1){
			return 1;
		}
		if(n==2){
			return 1;
		}
		i=3;
		while (i<=n){
			r = first+secend;//
			first = secend;
			secend = r;
			i++;
		}
		return r;
	}



	public static void main(String[] args) {
		System.out.println(fibonacci(32));
		System.out.println(finbonacciLoop(32));
	}
}
