package com.k.算法.leetcode.easy;

import java.math.BigInteger;

/**
 *
 * 两个二进制数字相加
 * Given two binary strings, return their sum (also a binary string).
 The input strings are both non-empty and contains only characters 1 or 0.
 Example 1:
 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 * created by k
 * 2018/11/29 15:10
 **/
public class LeetCode67 {

	public static void main(String[] args) {
		//1010
		//1011
		//    10101
	}

	/**
	 * 自己的解法，错误的
	 * @param a
	 * @param b
	 * @return
	 */
	public static String add(String a,String b){

		Integer integera = Integer.valueOf(a, 2);
		Integer integerb = Integer.valueOf(b, 2);

		return Integer.toBinaryString(integera+integerb);

	}

	/**
	 * 网上的做法，正确的
	 * @param a
	 * @param b
	 * @return
	 */
	public static String add2(String a,String b){

		BigInteger a1 = new BigInteger(a,2);
		BigInteger b1 = new BigInteger(b,2);
		return a1.add(b1).toString(2);
	}


}
