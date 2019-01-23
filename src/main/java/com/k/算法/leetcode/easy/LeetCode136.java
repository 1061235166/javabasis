package com.k.算法.leetcode.easy;

/**
 * 136. Single Number

 Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,1]
 Output: 1
 Example 2:

 Input: [4,1,2,1,2]
 Output: 4
 * @author wyk
 * @date 2019/1/23 14:08
 **/
public class LeetCode136 {


	//不使用额外的内存完成查找,时间复杂度是线性的

	/**
	 * @see com.k.算法.leetcode_cn.easy.array.只出现一次的数字
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		//利用 1^1=1; 1^0=0的特性
		return 1;
	}
}
