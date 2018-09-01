package com.k.binary;

/**
 * Created by k on 2018/6/4.
 */
public class BinaryOperation {

	public static void main(String[] args) {
		rightMove();
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
	 * 按位异或(^)，两个二进制数字进行对比，对于同一位上，如果数值相同则为 0，数值不同则为 1
	 * 3 ^ 5 = 6,而 6 ^ 5 = 3，所以异或可以做简单的加密解密操作
	 */
	public static void operationXOR(){
		String a = Integer.toBinaryString(21);
		String b = Integer.toBinaryString(24);
		System.out.println(a);
		System.out.println(b);
		System.out.println(21 ^ 24);

	}

	/**
	 * 右移操作
	 *  a >> b 将数值 a 的二进制数值从 0 位算起到第 b - 1 位，整体向右方向移动 b 位，符号位不变，高位空出来的位补数值 0。
	 *  5 >> 1 ===>  1000 0000 0000 0101 >> 1  = 1000 0000 0000 0010 = 2
	 *	7 >> 2 ===>  1000 0000 0000 0111 >> 2  = 1000 0000 0000 0001 = 1
	 *	9 >> 3 ===>  1000 0000 0000 1001 >> 3  = 1000 0000 0000 0001 = 1
	 *	11 >> 2 ===> 1000 0000 0000 1011 >> 2 = 1000 0000 0000 0010 = 2
	 */
	public static void rightMove(){
		System.out.println(Integer.toBinaryString(5));
	}


}
