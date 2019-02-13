package com.k.排序;

import com.k.排序.swap.BaseSwap;

import java.util.Arrays;

/**
 * 插入排序
 * 从集合头部开始，下标每向右移动一位，下标左边的元素总是会互相比较保证有序，等走到集合最右边，
 * 所有元素都是有序的了
 * Created by k on 2018/5/27.
 */
public class 插入排序 extends BaseSwap {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(random2));
        sort5(random2);
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

    /**
     * 来自于网上，感觉不好理解
     * @param a
     */
    public static void sort4(int [] a){
        int i, j, k;
        int n = a.length;
        for (i = 1; i < n; i++) {

            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--)
                if (a[j] < a[i])
                    break;

            //如找到了一个合适的位置
            if (j != i - 1) {
                //将比a[i]大的数据向后移
                int temp = a[i];
                for (k = i - 1; k > j; k--)
                    a[k + 1] = a[k];
                //将a[i]放到正确位置上
                a[k + 1] = temp;
            }
        }
    }

    /**
     * 使用小循环每次拿相邻两个元素作对比,如果左边比右边大,就swap操作
	 * 这种做法最直观
     * @param ints
     */
    public static void sort5(int [] ints){
    	//大循环从第一个元素开始往右走
		for(int i=0;i<ints.length;i++){
			//小循环从i开始往左走,如果发现相邻的两个元素左边比右边大,就交换位置,每次小循环走完,i左边的都为有序
			for(int j=i;j>0;j--){
				int a = ints[j];
				int b = ints[j-1];
				if(a<b){
					swap(ints,j,j-1);
				}else {
					//左边已经有序,所以不需要继续循环
					break;
				}
			}
		}
    }
}
