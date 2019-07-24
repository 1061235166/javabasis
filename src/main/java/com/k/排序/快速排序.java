package com.k.排序;

import com.k.排序.swap.BaseSwap;

import java.util.Arrays;

/**
 * Created by k on 2018/5/27.
 */
public class 快速排序 extends BaseSwap {

    public static void main(String[] args) {
        int[] random = BaseSwap.random2;
        System.out.println(Arrays.toString(random));
        sort(random);
        System.out.println(Arrays.toString(random));
    }

    public static void sort(int[]ints){
        sort(ints,0,ints.length-1);
    }

    private static void sort(int [] a,int l,int r){
        if (l < r) {
            int i,j,x;
            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while(i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if(i < j)
                    a[i++] = a[j];
                while(i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if(i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            sort(a, l, i-1); /* 递归调用 */
            sort(a, i+1, r); /* 递归调用 */
        }
    }
}
