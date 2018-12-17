package com.k.算法.leetcode_cn.easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * 颜色排序
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 示例:

 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 进阶：

 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * Created by k on 2018/12/14.
 */
public class 颜色排序 {

    public static void main(String[] args) {
        int[]ints=new int[]{2,0,2,1,1,0};
        sortColors1(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 自己的解法，但是使用了多次循环，复杂度不是O(n)
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

    /**
     * 网上的解法1
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }

    /**
     * 网上的解法2
     */
    public static void sortColors2(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            if (nums[i] == 1) count1++;
            if (nums[i] == 2) count2++;
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }
}
