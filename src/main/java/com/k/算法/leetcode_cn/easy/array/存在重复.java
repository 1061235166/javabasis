package com.k.算法.leetcode_cn.easy.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * Created by k on 2018/12/2.
 */
public class 存在重复 {


    public static boolean containsDuplicate(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return false;
        }
        Arrays.sort(nums);
        int index = 0;
        while (index<nums.length-1){
            int a =nums[index];
            int b =nums[index+1];
            if(a==b)
                return true;
            index++;
        }
        return false;
    }
}
