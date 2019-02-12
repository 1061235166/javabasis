package com.k.排序;

import com.k.排序.swap.BaseSwap;

import java.util.Arrays;

/**
 * 冒泡排序
 * 每次第一个元素和他右边的元素相比较，如果左边比右边打，就交换位置，第一轮过后最大元素就在最右边了
 * 依次执行，每轮过后剩余的最大元素都会靠右边
 * Created by k on 2018/5/25.
 */
public class 冒泡排序 extends BaseSwap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(random));
        sort3(random);
        System.out.println(Arrays.toString(random));

    }

	/**
	 * 冒泡排序
	 * @param input
	 */
	public static void sort2(int [] input){
		int length = input.length;
		for(int i=length-1;i>=0;i--){
			for(int j=0;j<i;j++){
//				System.out.println(i+"_"+j);
				int v1 = input[j];
				int v2 = input[j+1];
				if(v1>v2){
					swap(input,j,j+1);
				}
			}
		}
	}

    /**
     * 冒泡排序3，优化版，判断如果在一轮排序后，发现没有元素被交换，说明数组已经是有序的，退出循环
     *
     * @param ints
     */
	public static void sort3(int [] ints){
	    for(int i=ints.length-1;i>=0;i--){
	        boolean swap = false;
	        for(int j=0;j<i;j++){//必须是j<i，而不能是j<i-1，因为i是大循环的最后一个元素下标，j是i之前的最后一个元素
	            int a = ints[i];
	            int b = ints[j];
	            if(a<b)
	                swap(ints,i,j);
            }
            if(!swap)
                break;
        }
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