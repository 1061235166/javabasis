package com.k.算法.leetcode.easy;

import java.util.Arrays;

/**
 * 283. Move Zeroes

 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 * @author k
 * @date 2019/1/23 14:25
 **/
public class LeetCode283 {


	public static void main(String[] args) {
		int[] nums = {0,1,0,3,4,0};
		moveZeroes2(nums);
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 自己的解法,参考了网上
	 * @param nums
	 */
	public static void moveZeroes2(int[] nums) {
		int t=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				nums[t++]=nums[i];
			}
		}
		for(int i=t;i<nums.length;i++){
			nums[i]=0;
		}
	}
	public static void moveZeroes(int[] nums) {
		int s =0;
		int e=nums.length-1;
		while (s<=e){
			int a = nums[s];
			int b = nums[e];
			if(a==0 && b==0){

			}else if(a==0 && b!=0){

			}else if(a!=0 && b!=0){

			}else {

			}
		}
		if (nums == null || nums.length == 0) return;

		int insertPos = 0;
		for (int num: nums) {
			if (num != 0) nums[insertPos++] = num;
		}
	}
}
