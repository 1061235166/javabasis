package com.k.算法.leetcode_cn.easy.array;

/**
 * 136
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 说明：
 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 示例 1:
 输入: [2,2,1]
 输出: 1
 示例 2:
 输入: [4,1,2,1,2]
 输出: 4
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * created by k
 * 2018/12/3 10:13
 **/
public class 只出现一次的数字 {

	/**
	 * 问题的思路是利用异或的特性
	 * N ^ 0 = N
	 * N ^ N = 0
	 * N ^ M ^ N= M
	 * 也就是说如果一个数字如果出现两次那么他的异或结果为0
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(1 ^ 1);
		System.out.println(1 ^ 2);
		System.out.println(2 ^ 2);
		System.out.println(3 ^ 2);
		System.out.println(3 ^ 56);
		System.out.println(4 ^ 12 ^ 12);
		System.out.println(0 ^ 1 ^ 1);
		System.out.println(0 ^ 12);

		System.out.println(singleNumber(new int[]{1,7,4,7,5,5,1}));
	}

	/**
	 * 网上的解析方法
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		int ans =0;

		int len = nums.length;
		for(int i=0;i!=len;i++)
			ans ^= nums[i];

		return ans;
	}
}