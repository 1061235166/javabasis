package com.k.算法.leetcode.easy;

/**
 * 具体思路https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:

 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 示例:

 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * Created by k on 2018/12/11.
 */
public class LeetCode167 {

    /**
     * 使用二分查找，用网上的思路
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        for(int i =0;i<numbers.length;i++){
            int v = numbers[i];
            int r = target - v;
            int i1 = binarySearch(numbers, r);
            if(i1!=-1){
                return new int[]{r,i1};
            }
        }
        return null;
    }

    private static int binarySearch(int [] ints,int value){
        int s= 0;
        int e=ints.length-1;
        while (s>=e){
            int m = (s+e)/2;
            int n = ints[m];
            if(n>m){
                s = m+1;
            }else if(n<m){
                e= m-1;
            }else {
                return m;
            }
        }
        return -1;
    }

}
