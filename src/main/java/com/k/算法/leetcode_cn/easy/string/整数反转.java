package com.k.算法.leetcode_cn.easy.string;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * created by k
 * 2018/12/4 10:18
 **/
public class 整数反转 {

	public static void main(String[] args) {

		System.out.println(Math.abs(-1));


		int reverse = reverse(-2147483648);
		System.out.println(reverse);
	}

	public static int reverse(int x) {
		Integer max = Integer.MAX_VALUE;
		Integer min = Integer.MIN_VALUE;
		if(x==0) return  0;
		boolean isNegtive = false;
		if(x<0) isNegtive=true;
		int abs = Math.abs(x);//一个int类型的数字绝对值为负数，那么他绝对值转换时肯定是溢出了
		if(abs<0)return 0;
		StringBuilder sb = new StringBuilder(abs+"");
		sb.reverse();

		while (sb.charAt(0)=='0'){
			sb.deleteCharAt(0);
		}
		System.out.println(sb.toString());
		if(isNegtive){
			sb.insert(0,"-");
		}
		long i = Long.parseLong(sb.toString());
		if(i>max || i<min){
			return 0;
		}
		return (int)i;
	}
}