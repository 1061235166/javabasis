package com.k.算法.leetcode.easy;

/**
 * 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0 。

 说明：一个单词是指由字母组成，但不包含任何空格的字符串。

 示例:
 输入: "Hello World"
 输出: 5
 * created by k
 * 2018/11/29 14:15
 **/
public class LeetCode58 {

	public static void main(String[] args) {
		int a_b = lengthOfLastWord("a b");

		System.out.println(a_b);

		System.out.println(lengthOfLastWord2("a b1  11231231"));
	}

	//自己的解法
	public static int lengthOfLastWord(String s){
		String trim = s.trim();
		if(trim.length()==0){
			return 0;
		}
		String s1 = trim.replaceAll("\\s+", "&");
		int index = s1.lastIndexOf("&");
		if(index==-1){
			return s1.length();
		}
		return s1.length()-1-index;
	}

	/**
	 * 自己参考网友的写法
	 * @param s
	 * @return
	 */
	public static int lengthOfLastWord2(String s){
		int index = s.trim().length()-1;
		int len=0;
		boolean isStart = true;
		while (index>=0) {
			if (s.charAt(index)!=' ') {
				index--;
				len++;
			}else
				return len;
		}
		return len;
	}
}
