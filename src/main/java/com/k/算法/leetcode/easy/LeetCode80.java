package com.k.算法.leetcode.easy;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * created by wyk
 * 2018/11/26 15:14
 **/
public class LeetCode80 {
	public static int removeDuplicates(int[] nums) {
		int res = 0;
		int lastSameIndex = 0;
		for(int i=0;i<=nums.length-1;i++){
			int n=nums[i];
			if(i<nums.length-1){
				int m = nums[i+1];
				if(n==m){
					res++;
					i++;
				}
			}
		}
		return nums.length-res;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2,3,3,4,5,5,6,7}));
	}
}
