package com.k.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 每次第一个元素和他右边的元素相比较，如果左边比右边打，就交换位置，第一轮过后最大元素就在最右边了
 * 依次执行，每轮过后剩余的最大元素都会靠右边
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