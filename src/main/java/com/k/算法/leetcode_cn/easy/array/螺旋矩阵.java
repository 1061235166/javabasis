package com.k.算法.leetcode_cn.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/775/
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 示例 1:
 输入:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 输出: [1,2,3,6,9,8,7,4,5]
 示例 2:

 输入:
 [
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12]
 ]
 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * created by k
 * 2018/12/6 11:03
 *00 01 02 03,13,23,22,21,20,10,11,12
 * x=0,y=0;
 * xy,xy++,xy++,xy,
 **/
public class 螺旋矩阵 {

	public static void main(String[] args) {
		int[][]ints=new int[][]{
				new int[]{1,2,3,4},
				new int[]{5,6,7,8},
				new int[]{9,10,11,12}
		};
		spiralOrder(ints);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList();
		int x=0;
		int y=0;
		//遍历个数
		int times = 0;
		//宽度
		int w = matrix[0].length;
		//高度
		int h = matrix.length;
		int eleSize = w*h;

		while (times<=eleSize){
			int tempX = x;
			int tempY = y;
			if(tempY<h && tempY>=0){
				y++;
			}
			if(tempY== w && tempY>=0){
				x++;
			}
			if(tempX == h && tempX>=0){
				y--;
			}
			if(tempY==w && tempY>=0){
				x--;
			}

			System.out.println(x+"_"+y);
			times++;
		}
		return null;
	}
}
