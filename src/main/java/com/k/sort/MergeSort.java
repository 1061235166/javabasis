package com.k.sort;

import com.k.sort.swap.BaseSwap;

/**
 * 归并排序
 * 递归地将一个数组分成左右两边分别进行排序，最后合并排序结果
 * Created by k on 2018/5/27.
 */
public class MergeSort extends BaseSwap {

    public static void main(String[] args) {

    }

    public static void sort(int[]ints){

    }

    private static void mergeSort(int [] ints,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int [] copy = new int[ints.length];
        System.arraycopy(ints,low,copy,0,ints.length);
        for(int k=low;k<=high;k++){
            if(i>mid){
                ints[k]=copy[j++];
            }else if(j>high){
                ints[k]=copy[i++];
            }else if(copy[j]>copy[i]){
                ints[k]=copy[j++];
            }else {
                ints[k]=copy[i++];
            }
        }
    }
}
