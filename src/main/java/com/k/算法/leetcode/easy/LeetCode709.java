package com.k.算法.leetcode.easy;

/**
 * To Lower Case
 * created by wyk
 * 2018/11/26 17:55
 **/
public class LeetCode709 {

	public static void main(String[] args) {
		String a ="abcdefghijklmnopqrstuvwxyz";
		System.out.println(a.length());
		String b ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<a.length();i++){
			System.out.print((int)a.charAt(i)+"_");
		}
		System.out.println();
		for(int i=0;i<b.length();i++){
			System.out.print((int)b.charAt(i)+"_");
		}
		int r = 77;
		String s = String.valueOf((char) r);
		System.out.println(s);

		System.out.println(toLowerCase("AYhaisdhuAYyudashYUDYSTD"));
	}

	public static String toLowerCase(String str){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>= 65 && str.charAt(i)<=90){
				char c = str.charAt(i);
				int r = c + 32;
				String s = String.valueOf((char)r);
				sb.append(s);
			}else {
				sb.append(String.valueOf(str.charAt(i)));
			}
		}
		return sb.toString();
	}

	/*
	* 面试这样鞋直接挂
	 */
	public static String toLowerCase2(String str){
		return str.toLowerCase();
	}

}
