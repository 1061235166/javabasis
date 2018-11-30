package com.k.算法.leetcode.easy;

import java.util.*;
import java.util.stream.Stream;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 * created by k
 * 2018/11/30 14:38
 **/
public class LeetCode1 {

	public static int [] solution(int []ints,int target){
		for(int i=0;i<ints.length;i++){
			for(int j=0;j<ints.length;j++){
				if(i!=j && (ints[i]+ints[j]==target)){
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] solution = solution(new int[]{2, 7, 11, 15}, 9);
		System.out.println(Arrays.toString(solution));
		System.out.println(Arrays.toString(solution(new int[]{3,2,4}, 6)));
	}
}
