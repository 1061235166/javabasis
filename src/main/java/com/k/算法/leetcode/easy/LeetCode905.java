package com.k.算法.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-array-by-parity/description/
 * 数组奇偶排序
 * 905. Sort Array By Parity
 Easy
 269
 32

 Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

 You may return any answer array that satisfies this condition.

 Example 1:

 Input: [3,1,2,4]
 Output: [2,4,3,1]
 The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * created by k
 * 2018/12/10 11:24
 **/
public class LeetCode905 {


	public static void main(String[] args) {
		int[] ints = sortArrayByParity3(new int[]{3, 1, 2, 4,5,6,2,123,1});
		System.out.println(Arrays.toString(ints));
	}

	/**
	 * 网友的解法
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParity(int[] A) {
		for (int i = 0, j = 0; j < A.length; j++)
			if (A[j] % 2 == 0) {
				int tmp = A[i];
				A[i++] = A[j];
				A[j] = tmp;;
			}
		return A;
	}

	/**
	 * 自己在参考了网友的解法后得出的
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParity2(int[] A) {
		int s = 0;
		int index = 0;
		while (s<A.length){
			if(A[s]%2==0){
				int temp = A[s];
				int b = A[index];
				A[index++]=temp;
				A[s]=b;
			}
			s++;
		}
		return A;
	}

	/**
	 * 网上的解法
	 * 双指针方法，需要一个新的数组接受数据，比较好理解的
	 * @param A
	 * @return
	 */
	public static int[]sortArrayByParity3(int []A){
		int oddIndex = A.length - 1;
		int evenIndex = 0;
		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				result[evenIndex] = A[i];
				evenIndex++;
			} else {
				result[oddIndex] = A[i];
				oddIndex--;
			}
		}
		return result;
	}
}