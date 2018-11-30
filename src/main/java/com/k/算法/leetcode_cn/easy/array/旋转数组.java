package com.k.算法.leetcode_cn.easy.array;

import java.util.Arrays;

/**
 * 旋转数组
 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 示例 1:
 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 示例 2:

 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]
 说明:

 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的原地算法。
 * Created by k on 2018/11/30.
 */
public class 旋转数组 {


    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4};// 1234 4123 3421 1342
        rotate2(nums,1);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        while (k>0){
            k--;
//            int s=0;
            for(int i=0;i<nums.length;i++){
                if(i==nums.length){
                    break;
                }
                int f = nums[i];
                int s = nums[i+1];
                nums[i]=s;
                nums[i+1]=f;
            }
        }
        return;
    }

    public static void rotate2(int[] nums, int k) {
        int temp, previous;
//        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
//            }
        }
    }
}
