package com.k.算法.leetcode.easy;

import java.util.Objects;

/**
 * 验证回文字符串
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 Note: For the purpose of this problem, we define empty string as valid palindrome.
 Example 1:
 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:
 Input: "race a car"
 Output: false
 * created by wyk
 * 2018/11/29 10:53
 **/
public class LeetCode125 {

	static Integer get(){
		return null;
	}

	public static void main(String[] args) {
//		System.out.println(Objects.equals(null,1));
//		System.out.println(Objects.equals(1,get()));
//
//		Integer integer = get();
//		int a = 1;
//		System.out.println(integer==a);

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("r123ar"));
		System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome2("r123ar"));
	}

	/**
	 * 自己的解法
	 * @param string
	 * @return
	 */
	public static boolean isPalindrome(String string){
		int s = 0;
		int e = string.length()-1;
		while (s<e){
			char c = string.charAt(s);
			char es = string.charAt(e);
			boolean isStartNum=Character.isDigit(c);
			boolean isStartLetter=Character.isLetter(c);

			boolean isEndNum = Character.isDigit(es);
			boolean isEndLetter = Character.isLetter(es);
			if(isStartNum && isEndNum){
				if(c==es){
					s++;
					e--;
					continue;
				}
				return false;
			}else if(isStartLetter && isEndLetter){
				if(Character.toLowerCase(c) == Character.toLowerCase(es)){
					s++;
					e--;
					continue;
				}
				return false;
			}
			if((!isStartNum || !isStartLetter) && (isEndNum || isEndLetter)){
				s++;
			}
			if((!isEndNum || !isEndLetter) && (isStartNum || isStartLetter)){
				e--;
			}
		}
		return true;
	}

	/**
	 * 别人的解法
	 * @param string
	 * @return
	 */
	public static boolean isPalindrome2(String string){
		//把所有不是大小写字母和数字的字符都转换为空格
		String r = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//		System.out.println(r.toLowerCase());
		//然后对比
		int s = 0;
		int e = r.length()-1;
		while (s<=e){
			if(r.charAt(s++)!=r.charAt(e--)){
				return false;
			}
		}
		return true;
	}

}