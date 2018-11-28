package com.k.datastructure.search;

/**
 * 二分查找，查找一个有序的数组中某个数的下标
 * Created by k on 2018/5/20.
 */
public class BinarySearch {

    public static void main(String[] args) {
		int [] array = new int[]{1,3,4,5,6,7,8,11,14,16};
		System.out.println(search(array,3,0,array.length-1));
    }

    public static int search(int [] array,int num,int s, int e){
    	//不能用while
		if (e>=s){
			int m = (e+s)/2;
			int r = array[m];
			System.out.println("m:"+m+",r:"+r);
			if(r==num){
				return m;
			}else if(r>num){
				return search(array,num,s,m-1);
			}else if(r<num){
				return search(array,num,m+1,e);
			}
		}
    	return -1;
	}
}
