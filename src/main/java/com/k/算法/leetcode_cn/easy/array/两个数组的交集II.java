package com.k.算法.leetcode_cn.easy.array;

import java.util.*;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 * created by wyk
 * 2018/12/3 10:59
 **/
public class 两个数组的交集II {

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7},4));
		System.out.println(Arrays.toString(intersect(new int[]{4,9,5},new int[]{9,4,9,8,4})));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer>list = new ArrayList<>();
		Arrays.sort(nums2);
		for(int i=0;i<nums1.length;i++){
			if(binarySearch(nums2,nums1[i])!=-1){
				list.add(nums1[i]);
			}
		}
		int [] ints = new int[list.size()];
		Iterator<Integer> iterator = list.iterator();
		int index=0;
		while (iterator.hasNext()){
			ints[index++]=iterator.next();
		}
		return ints;
	}
	private static int binarySearch(int []num,int n){
		int start = 0;
		int end = num.length-1;
		while(start<=end){
			int m = (start+end)/2;
			int v = num[m];
			if(v<n){
				start = m+1;
//				end = num.length-1;
			}else if(v>n){
//				start = 0;
				end = m-1;
			}else {
				return m;
			}
		}
		return -1;
	}

	public static int[]intersect2(int[] nums1, int[] nums2){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < nums1.length; i++){
			if(map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i])+1);
			}
			else{
				map.put(nums1[i], 1);
			}
		}

		for(int i = 0; i < nums2.length; i++){
			if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}
		int[] r = new int[result.size()];
		for(int i = 0; i < result.size(); i++){
			r[i] = result.get(i);
		}
		return r;
	}
}
