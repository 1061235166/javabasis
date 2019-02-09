package com.k.排序;

import com.k.排序.swap.BaseSwap;

import java.util.Arrays;

/**
 * 冒泡排序
 * 每次第一个元素和他右边的元素相比较，如果左边比右边打，就交换位置，第一轮过后最大元素就在最右边了
 * 依次执行，每轮过后剩余的最大元素都会靠右边
 * Created by k on 2018/5/25.
 */
public class BubbleSort extends BaseSwap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(random));
        sort2(random);
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