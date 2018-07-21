package com.k.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 从集合头部开始，下标每向右移动一位，下标左边的元素总是会互相比较保证有序，等走到集合最右边，
 * 所有元素都是有序的了
 * Created by k on 2018/5/27.
 */
public class InsertSort extends BaseSwap{

    public static void main(String[] args) {
        System.out.println(Arrays.toString(random2));
        sort3(random2);
        System.out.println(Arrays.toString(random2));
    }

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


    public static void sort2(int [] ints){
        for(int i=1;i<ints.length;i++){
            int temp = ints[i];
            int j = i-1;
            for(;j>=0 && temp > ints[j] ;j--){
                ints[j]=ints[j+1];
            }
            ints[j+1]=temp;
        }
    }

    /**
     *  from 算法第四版
     * @param inputs
     */
    public static void sort3(int [] inputs){
        for(int i=1;i<inputs.length;i++){
            for(int j=i;j>0 && inputs[j]<inputs[j-1];j--){
                swap(inputs,j,j-1);
            }
        }
    }
}
