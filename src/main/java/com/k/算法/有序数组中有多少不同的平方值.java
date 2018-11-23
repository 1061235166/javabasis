package com.k.算法;

/**
 * 今日头条面试
 * https://mp.weixin.qq.com/s?__biz=MzI3ODg2OTY1OQ==&mid=2247484020&idx=1&sn=9d992d490a2b8f5e74f17e3547b29f97&chksm=eb512180dc26a8962fb84545204215d9d9e157a29b39544342908a0e478faf1aeda4b77c7de9&mpshare=1&scene=1&srcid=1117jJhcKzmoAQQFzzY7Lj3q#rd
 * 给你一个有序整数数组，数组中的数可以是正数、负数、零，请实现一个函数，这个函数返回一个整数：返回这个数组所有数的平方值中有多少种不同的取值。举例：
 * nums = {-1,1,1,1},
 * 那么你应该返回的是：1。因为这个数组所有数的平方取值都是1，只有一种取值
 * nums = {-1,0,1,2,3}
 * 你应该返回4，因为nums数组所有元素的平方值一共4种取值：1,0,4,9
 * created by k
 *
 * 双指针算法
 * 2018/11/23 13:52
 **/
public class 有序数组中有多少不同的平方值 {

	public static void main(String[] args) {
		System.out.println(handle(new int[]{-1,0,3,6,8,11,11}));
	}

	public static int handle(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// result的缩写，最后的返回值
		int res = 0;
		//i是前指针；j是后指针
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int num1 = Math.abs(nums[i]);
			int num2 = Math.abs(nums[j]);
			if (num1 > num2) {//移动i
				// 这两个数的绝对值不相等
				res += 1;
				while (i <= j && Math.abs(nums[i]) == num1)
					//过滤掉相邻的绝对值相等的数
					i++;
			} else if (num1 < num2) {
				// 这两个数的绝对值不相等
				res += 1;
				while (i <= j && Math.abs(nums[j]) == num2)
					//过滤掉相邻的绝对值相等的数
					j--;
			} else {
				res += 1;
				while (i <= j && /*去重 */ Math.abs(nums[i]) == num1)
					i++;
				while (i <= j &&/*去重*/ Math.abs(nums[j]) == num2)
					j--;
			}
		}
		return res;
	}
}
