package com.k.算法.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 Note:

 S and J will consist of letters and have length at most 50.
 The characters in J are distinct.
 * @author wyk
 * @date 2019/1/23 11:47
 **/
public class LeetCode771 {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("z","ZZ"));
	}

	/**
	 * 自己的写法
	 * @param J
	 * @param S
	 * @return
	 */
	public static int numJewelsInStones(String J, String S) {
		Map<Character,Integer> map = new HashMap<>();
		for(Character c : S.toCharArray()){
			Integer n = map.get(c);
			if(n==null){
				map.put(c,1);
			}else {
				map.put(c,n+1);
			}
		}
		int s=0;
		for(Character c : J.toCharArray()){
			Integer n = map.get(c);
			if(n!=null){
				s+=n;
			}
		}
		return s;
	}

}
