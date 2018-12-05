package com.k.算法.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 大数字相加
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * created by k
 * 2018/12/5 09:57
 **/
public class LeetCode415 {

	public static void main(String[] args) {

		addStrings("9999999999999999999999999999999999999999999999999999","12837182731987718371239812637123123123");

	}

	/**
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String addStrings(String num1, String num2) {

		StringBuilder s1 = new StringBuilder(num1);
		StringBuilder s2 = new StringBuilder(num2);
		s1.reverse();
		s2.reverse();
		int length = Math.max(num1.length(),num2.length())+1;
		while (s1.length()<length){
			s1.append('0');
		}
		while (s2.length()<length){
			s2.append('0');
		}

		List<String>list = new ArrayList<>();
		int index = 0;
		Stack<String>stack=new Stack<>();
		while (index<=length-1){
			char c1 = s1.charAt(index);
			char c2 = s2.charAt(index);
			int n1 = Character.getNumericValue(c1);
			int n2 = Character.getNumericValue(c2);

			int v=0;
			if(!stack.isEmpty()){
				String pop = stack.pop();
				v = Integer.parseInt(pop);
			}
			int r = n1+n2+v;
			if(r>=10){
				r = r-10;
				stack.push(1+"");
			}
			list.add(r+"");

			index++;
		}

		int in = list.size()-1;
		StringBuilder stringBuilder = new StringBuilder();
		while (in>=0){
			stringBuilder.append(list.get(in));
			in--;
		}
		System.out.println(Arrays.toString(stack.toArray()));
		while (stringBuilder.charAt(0)=='0'){
			if(stringBuilder.toString().equals("0")){
				break;
			}
			stringBuilder.deleteCharAt(0);
		}

		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}
}
