package com.k.算法.leetcode_cn.easy.array;

/**
 * https://leetcode.com/problems/find-pivot-index/
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

 示例 1:

 输入:
 nums = [1, 7, 3, 6, 5, 6]
 输出: 3
 解释:
 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 同时, 3 也是第一个符合要求的中心索引。
 示例 2:

 输入:
 nums = [1, 2, 3]
 输出: -1
 解释:
 数组中不存在满足此条件的中心索引。
 说明:

 nums 的长度范围为 [0, 10000]。
 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * created by k
 * 2018/12/7 10:43
 **/
public class 寻找数组的中心索引 {

	public static void main(String[] args) {
		System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
		System.out.println(pivotIndex(new int[]{1,2,3}));
		System.out.println(pivotIndex(new int[]{-1,-1,-1,0,1,1}));
		System.out.println(pivotIndex3(new int[]{1,7,3,6,5,6}));
	}

	/**
	 * 自己的解法，在遇到特别大的数组的时候会超时
	 * @param nums
	 * @return
	 */
	public static int pivotIndex(int[] nums) {
		for(int i=0;i<nums.length;i++){
			int index = i;
			int l = index;
			int r = index;
			int ls = 0;
			int rs = 0;
			while (l>=0 && r<=nums.length-1){
				for (int j=l;j>=0;j--){
					ls+=nums[j];
				}
				for (int j=r;j<=nums.length-1;j++){
					rs+=nums[j];
				}
				if(ls == rs){
					return i;
				}
				l--;
				r++;
			}
		}
		return -1;
	}

	/**
	 * 网上的解法，先把数组的总和算出来，然后从数组左边开始，把左边的总和算出来，然后数组总和减去左边总和得出右边总和，如果左边总和
	 * 等于右边总和，返回下标，否则下标+1，重复以上操作
	 * @param nums
	 * @return
	 */
	public static int pivotIndex2(int[] nums) {
		if (nums.length == 0)
			return -1;
		int leftSum = 0, rightSum = 0;
		for (int num : nums)
			rightSum += num;
		for (int i = 0; i < nums.length; i++) {
			rightSum -= nums[i];
			if (leftSum == rightSum)
				return i;
			leftSum += nums[i];
		}
		return -1;
	}

	/**
	 * 自己的解法，通过了
	 * 思路是先把数组所有项的综合求出来，然后遍历数组，算出左边的总数和右边的总数，分别减去当前下标的数值，如果相等，返回，
	 * 否则继续向右迭代
	 * @param nums
	 * @return
	 */
	public static int pivotIndex3(int[] nums){
		int sum = 0;
		for(int i : nums){
			sum+=i;
		}
		int leftSum= 0;
		for(int i=0;i<nums.length;i++){
			int n = nums[i];
//			leftSum+=n;
			int rightSum = sum - leftSum - n;
			if(leftSum ==rightSum){
				return i;
			}
			leftSum+=n;
		}
		return -1;
	}
}
