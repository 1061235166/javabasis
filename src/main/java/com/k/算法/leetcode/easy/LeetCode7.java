package com.k.算法.leetcode.easy;

/**
 * 反转整数
 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321

 Example 3:

 Input: 120
 Output: 21
 * created by k
 * 2018/11/30 14:19
 **/
public class LeetCode7 {

	//todo 未完成
	public static int solution(int num){
		if(num==0){
			return 0;
		}
		StringBuilder sb =new StringBuilder(num+"");
		int i1 = sb.indexOf("-");
		boolean isNegative= false;
		if(i1!=-1){
			isNegative = true;
			sb.deleteCharAt(0);
		}
		sb.reverse();
		while (sb.charAt(0)=='0'){
			sb.deleteCharAt(0);
		}

		Integer i = 0;
		if(num<0){
			i = Integer.valueOf(sb.toString());
		}
		if(isNegative){

		}
		return 1;
	}

	public static void main(String[] args) {

	}
}
