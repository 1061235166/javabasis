package com.k.算法.leetcode.easy;

/**
 * 删除已排序数组中的重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,0,1,1,1,2,2,3,3,4],

 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

 你不需要考虑数组中超出新长度后面的元素。
 * created by k
 * 2018/11/29 16:53
 **/
public class LeetCode26 {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2,2,2,2,3,4,5,6,7,8,9,9,9,9}));
	}

	/**
	 * 自己的解法，错误的，没有做到去重复
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int len = 0;
		if(nums.length==0)
			return 0;
		int first = nums[0];
		int index = -1;
		for(int i=1;i<nums.length;i++){
			int s = nums[i];
			if(i==1){
				len++;
				first=s;
				continue;
			}
			if(s!=first){
				len++;
				first=s;
			}
		}
		return len;
	}
}
