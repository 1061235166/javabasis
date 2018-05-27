package com.k.sort;

/**
 * Created by k on 2018/5/25.
 */
public class BaseSwap {

    public static int[]random
            =new int[]{321,743,23,54,4567,565,5,23,4,235,54,345,9650,219};

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
