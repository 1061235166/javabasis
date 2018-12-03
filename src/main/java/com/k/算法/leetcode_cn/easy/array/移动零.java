package com.k.算法.leetcode_cn.easy.array;

import java.util.Arrays;

/**
 *
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 示例:
 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 * created by k
 * 2018/12/3 15:37
 **/
public class 移动零 {

	/**
	 * 网上的解法
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {

		int p = 0;// Index of none-zero number
		for (int i : nums)
			if (i != 0)
				nums[p++] = i;
		while (p < nums.length)
			nums[p++] = 0;
	}

	public static void main(String[] args) {
		int []ints =new int[]{0,1,0,3,12};
		moveZeroes(ints);
		System.out.println(Arrays.toString(ints));
		int[]ints1={0,0,1};
		moveZeroes(ints1);
		System.out.println(Arrays.toString(ints1));
	}
}
