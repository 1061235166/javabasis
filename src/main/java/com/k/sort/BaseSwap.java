package com.k.sort;

/**
 * Created by k on 2018/5/25.
 */
public class BaseSwap {
    /**
     * 交换数组中下标a和b的元素
     * @param ints
     * @param a
     * @param b
     */
    public static void swap(int [] ints,int a,int b){
        int v1= ints[a];
        int v2= ints[b];
        ints[a]=v2;
        ints[b]=v1;
    }
}
