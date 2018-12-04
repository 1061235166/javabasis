package com.k.算法.leetcode_cn.easy.string;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。
 * created by k
 * 2018/12/4 17:18
 **/
public class 最长公共前缀 {

	public static void main(String[] args) {
		String s = longestCommonPrefix(new String[]{"123123", "12asdasd", "127837812738123"});
		System.out.println(s);
	}


	/**
	 * 自己的解法，有问题，写了一半写不下去了
	 *
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder m = new StringBuilder();
		int index = 0;
		StringBuilder[] sbs = new StringBuilder[strs.length];
		int[] ints = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			ints[i] = strs[i].length();
		}
		Arrays.stream(ints);
		int min = ints[0];
		System.out.println(min);

		while (index < min) {
			for (int i = 0; i < strs.length; i++) {
				StringBuilder sb = sbs[i];
				if (sb == null) {
					sbs[i] = new StringBuilder();
					sb = sbs[i];
				}
				String str = strs[i];
				sb.append(str.charAt(index));
			}
			StringBuilder s1 = new StringBuilder();
			for (int i = 0; i < sbs.length; i++) {
				s1.append(sbs[i]);
			}
//			System.out.println(s1.toString());
			String s = s1.toString();
			String temp = s.charAt(index) + "";
			boolean isGG = true;
			for (int i = 0; i < s.length(); i++) {
				String t = s.charAt(i) + "";
				if (t.equals(temp)) {
					temp = t;
				} else {
					isGG = false;
				}
			}
			if (isGG) {
				m.append(s1.charAt(index));
			}
			System.out.println(isGG);
			index++;
		}

		System.out.println(m.toString());
		return null;
	}



}