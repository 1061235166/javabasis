package com.k.排序;

import com.k.排序.swap.BaseSwap;

/**
 * 希尔排序，把一个数组按照固定间隔分开，对每个分开的数组进行插入排序
 * Created by k on 2018/5/27.
 */
public class ShellSort extends BaseSwap {

    public static void main(String[] args) {
        int[] ints = randomArray();
        System.out.println(toString(ints));
        sort(ints);
        System.out.println(toString(ints));
    }

    public static void sort(int[]ints){
        int gap = ints.length/3;
        while (gap>=1){
            for(int i=gap;i<ints.length;i=i+gap){
                for(int j=i;j>=gap && ints[j]<ints[j-gap];j-=gap){
                    swap(ints,j,j-gap);
                }
            }
            gap =gap/3;
        }
    }
}
