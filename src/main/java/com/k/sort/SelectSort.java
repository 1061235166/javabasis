package com.k.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 从所有元素中找到最小（最大）的元素，放在第一个（最后一个）位置，然后继续在剩下的元素循环以上操作，
 * 到最后，所有元素都是有序的了
 * Created by k on 2018/5/25.
 */
public class SelectSort extends BaseSwap{
    public static void sort(int [] ints){
        for(int i=0;i<ints.length;i++){
            for(int j=i;j<ints.length;j++){
                int a = ints[i];
                int b = ints[j];
                if(a>b){
                    swap(ints,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] ints = {3,4,6,7,2,3,546,56,812,3,6,7,6};
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

}
