package com.k.sort;

import java.util.Arrays;

/**
 * Created by k on 2018/5/25.
 */
public class BaseSwap {

    public static int[]random
            =new int[]{321,743,23,54,4567,565,5,23,4,235,54,345,9650,219};
    public static int[]random2
            =new int[]{511,456,56,245,34,467,6,78,32,54,67,891,12,567,67858};
    /**
     * 交换数组中下标a和b的元素
     * @param ints
     * @param a
     * @param b
     */
    public static void swap(int [] ints,int a,int b){
        try {
            int v1= ints[a];
            int v2= ints[b];
            ints[a]=v2;
            ints[b]=v1;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("indexa="+a+"indexb="+b);
            throw new RuntimeException("indexa="+a+"indexb="+b);
        }
    }

    public static String toString(int[]ints){
        return Arrays.toString(ints);
    }
}
