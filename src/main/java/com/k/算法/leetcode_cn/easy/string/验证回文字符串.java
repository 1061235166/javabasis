package com.k.算法.leetcode_cn.easy.string;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:
 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 * created by k
 * 2018/12/4 13:13
 **/
public class 验证回文字符串 {

	public static void main(String[] args) {
		boolean palindrome = isPalindrome2("A man, a plan, a canal: Panama");
		System.out.println(palindrome);
		boolean palindrome1 = isPalindrome("0p");
		System.out.println(palindrome1);
	}

	public static boolean isPalindrome2(String s){
		char[] chars = s.toLowerCase().toCharArray();
		int st = 0;
		int ed = chars.length-1;
		while (st<ed){
			char a = chars[st];
			char b = chars[ed];
			if(!Character.isLetterOrDigit(a)){
				st++;
			}else if(!Character.isLetterOrDigit(b)){
				ed--;
			}else {
				if(Character.isLetterOrDigit(a) && Character.isLetterOrDigit(b) && a==b){
					st++;
					ed--;
					continue;
				}
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome(String s) {
		s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		char[] chars = s.toCharArray();
		System.out.println(s);
		int st = 0;
		int ed = chars.length-1;
		while (st<ed){
			char a = chars[st];
			char b = chars[ed];
			if(a!=b){
				return false;
			}
			st++;
			ed--;
		}
		return true;
	}
}