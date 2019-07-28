package com.k.算法.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * Created by k on 2019/7/28.
 */
public class LeetCode268 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,6};
        int i = missingNumber2(nums);
        System.out.println(i);
        int reduce = IntStream.range(0, 15).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

    /**
     * 排序之后对每个位置上的数字进行对比
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]!=0){
            return 0;
        }
        int last = nums[nums.length-1];
        if(last==nums.length-1){
            return nums.length;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return nums[i]-1;
            }
        }
        return -1;
    }

    //使用hashmap
    public static int missingNumber2(int[] nums){
        Arrays.sort(nums);
        if(nums[0]!=0){
            return 0;
        }
        int last = nums[nums.length-1];
        if(last==nums.length-1){
            return nums.length;
        }
        Set<Integer>set=new HashSet<>();
        int last2 = nums.length;
        for(int i=0;i<last2;i++){
            set.add(i);
        }
        for(int i:nums){
            if(!set.contains(i)){
                return i-1;
            }
        }
        return -1;
    }
}
