package com.k.算法.leetcode_cn.easy.array;

/**
 * https://leetcode.com/problems/sort-colors/
 * 颜色排序
 * Created by k on 2018/12/14.
 */
public class 颜色排序 {
    /**
     * 自己的解法
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int a=0,b=0,c=0;
        for(int n : nums){
            if(n==0){
                a++;
            }else if(n==1){
                b++;
            }else if(n==2){
                c++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(a!=0){
                nums[i]=0;
                a--;
            }  else if(b!=0){
                nums[i]=1;
                b--;
            } else if(c!=0){
                nums[i]=2;
                c--;
            }
        }
    }
}
