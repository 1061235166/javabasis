package com.k.排序;

import com.k.排序.swap.BaseSwap;

import java.util.Arrays;

/**
 * 选择排序
 * 从所有元素中找到最小（最大）的元素，放在第一个（最后一个）位置，然后继续在剩下的元素循环以上操作，
 * 到最后，所有元素都是有序的了
 * 不稳定排序
 * Created by k on 2018/5/25.
 */
public class 选择排序 extends BaseSwap {

    public static void sort(int [] ints){
        for(int i=0;i<ints.length;i++){
            int min = i;
            for(int j=i+1;j<ints.length;j++){
                int a = ints[min];
                int b = ints[j];
                if(a>b){
                    min = j;
                }
            }
            swap(ints,i,min);
        }
    }

    public static void main(String[] args) {
        int [] ints = {3,4,6,7,2,3,546,56,812,3,6,7,6};
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
