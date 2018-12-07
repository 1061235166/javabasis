package com.k.算法.leetcode_cn.easy.array;


/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
 * created by k
 * 2018/12/3 17:04
 **/
public class 有效的数独 {

	public static void main(String[] args) {
		char[][]board = new char[][]{
				new char[]{'1','2','3','4','5','6','7','8','9'},
				new char[]{'0','9','8','7','6','5','4','3','2'}
		};
		isValidSudoku(board);
	}

	public static boolean isValidSudoku(char[][] board) {
		int r = 0;
		int c= 0;
		while (r<9 && c<2){
			while (r<9){
				System.out.println(r+"_"+c);
//				char cs = board[r][c];
//				System.out.print(cs+",");
				r++;
			}
			c++;
			r=0;
			System.out.println();
		}
		return true;
	}
}
