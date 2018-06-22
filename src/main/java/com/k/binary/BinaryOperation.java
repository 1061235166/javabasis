package com.k.binary;

/**
 * Created by k on 2018/6/4.
 */
public class BinaryOperation {

	public static void main(String[] args) {
		operationAND();
		System.out.println("====");
		operationOR();
	}
	/**
	 * 按位与，两个二进制数字进行对比，从最高位到最低位一一对应，如果对应的位的值都是1，结果就是1，否则是0
	 */
	public static void operationAND(){
		String s = Integer.toBinaryString(100);
		String s1 = Integer.toBinaryString(5001);
		System.out.println(s);
		System.out.println(s1);
		int r = 100 & 5001;
		System.out.println(r);
		System.out.println(Integer.toBinaryString(r));
	}

	/**
	 * 按位或，两个二进制数字进行对比，从最高位到最低位一一对应，如果对应的位只要有一个为1，结果就是1，否则是0
	 */
	public static void operationOR(){
		String s = Integer.toBinaryString(100);
		String s1 = Integer.toBinaryString(5001);
		System.out.println(s);
		System.out.println(s1);
		int r = 100 | 5001;
		System.out.println(r);
		System.out.println(Integer.toBinaryString(r));
	}

	/**
	 * 取反，每位值位1取0，为0取1
	 */
	public static void bitInversion(){
		String s = Integer.toBinaryString(321);
		System.out.println(s);
		int r = (~321);
		System.out.println(Integer.toBinaryString(r));
	}

	/**
	 * 按位异或
	 */
	public static void operationXOR(){

	}
}
