package com.k.算法.leetcode.easy;

/**
 * 汉明距离
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 2^31.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 * @author wyk
 * @date 2019/1/23 13:42
 **/
public class LeetCode461 {

	public static void main(String[] args) {
		int a= 1^2;

	}

	/**
	 * 网上参考的
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance(int x, int y) {
		return Integer.bitCount(x^y);
	}
}
