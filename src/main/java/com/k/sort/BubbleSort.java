package com.k.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 每次第一个元素和他右边的元素相比较
 * Created by k on 2018/5/25.
 */
public class BubbleSort extends BaseSwap{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(random));
        sort(random);
        System.out.println(Arrays.toString(random));

    }

    public static void sort(int [] ints){
        boolean swap;
        int lastSortdIndex = ints.length;
        do{
            swap = false;
            for(int i =0;i<lastSortdIndex-1;i++){
                int a= ints[i];
                int b= ints[i+1];
                if(a>b){
                    swap(ints,i,i+1);
                    swap=true;
                }
            }
            lastSortdIndex--;
        }while (swap);
    }
}