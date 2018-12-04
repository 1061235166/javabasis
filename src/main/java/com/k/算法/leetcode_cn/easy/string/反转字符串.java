package com.k.算法.leetcode_cn.easy.string;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。

 示例 1:

 输入: "hello"
 输出: "olleh"
 示例 2:

 输入: "A man, a plan, a canal: Panama"
 输出: "amanaP :lanac a ,nalp a ,nam A"
 * created by k
 * 2018/12/4 09:55
 **/
public class 反转字符串 {

	public static void main(String[] args) {
		String a = "hello";
		for(char s :a.toCharArray()){
			System.out.print(s);
		}
		System.out.println(reverseString("hello"));
	}

	/**
	 * 双指针思路
	 * @param s
	 * @return
	 */
	public static String reverseString(String s) {
		int st = 0;
		int ed = s.length()-1;
		char[]cs = new char[s.length()];
		char[] chars = s.toCharArray();
		while (st<=ed){
			char a = chars[st];
			cs[st]=chars[ed];
			cs[ed]=a;
			st++;
			ed--;
		}
		return new String(cs);
	}
}
