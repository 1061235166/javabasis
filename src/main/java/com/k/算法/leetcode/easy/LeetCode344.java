package com.k.算法.leetcode.easy;

/**
 * 反转字符串
 * Write a function that takes a string as input and returns the string reversed.
	Example 1:
	Input: "hello"
	Output: "olleh"
	Example 2:

	Input: "A man, a plan, a canal: Panama"
	Output: "amanaP :lanac a ,nalp a ,nam A"
 * created by wyk
 * 2018/11/29 19:05
 **/
public class LeetCode344 {
	/**
	 * 网络上解法
	 * @param s
	 * @return
	 */
	public static String reverse1(String s){
		char[] chars = s.toCharArray();
		int st = 0;
		int ed = s.length()-1;

		while (st<ed){
			char a = chars[st];
			char b = chars[ed];
			chars[ed]=a;
			chars[st]=b;
			st++;
			ed--;
		}
		return new String(chars);
	}

	public static String reverse2(String s){
		return new StringBuilder(s).reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(reverse1("A man, a plan, a canal: Panama").equals("amanaP :lanac a ,nalp a ,nam A"));
	}
}
