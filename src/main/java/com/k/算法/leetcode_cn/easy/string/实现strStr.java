package com.k.算法.leetcode_cn.easy.string;


/**
 * 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:

 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * created by k
 * 2018/12/4 16:21
 **/
public class 实现strStr {

	public static void main(String[] args) {

		System.out.println(strStr("hello","ll"));



	}

	/**
	 * 自己的解答方法，通过
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		if(needle==null ||  needle.trim().equals("")){
			return 0;
		}
		if(haystack==null){
			return -1;
		}

		char[] chars = haystack.toCharArray();
		int l = needle.length();
		for(int i=0;i<chars.length;i++){
			Character[]cs = new Character[l];
			int n = 0;
			int a = i;
			if(i>chars.length-l){
				break;
			}
			while (n<l) {
				cs[n]=chars[a];
				n++;
				a++;
			}
			char[]copy=new char[l];
			for(int x=0;x<cs.length;x++){
				copy[x]=cs[x];
			}
			String s = new String(copy);
			System.out.println(s);
			if(s.equals(needle)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 网上的解法
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr2(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) return i;
				if (i + j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}
}
