package com.k.算法.leetcode_cn.easy.string;

/**
 * leetcode NO.8
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

 在任何情况下，若函数不能进行有效的转换时，请返回 0。

 说明：

 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 示例 1:

 输入: "42"
 输出: 42
 示例 2:

 输入: "   -42"
 输出: -42
 解释: 第一个非空白字符为 '-', 它是一个负号。
 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 示例 3:

 输入: "4193 with words"
 输出: 4193
 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 示例 4:

 输入: "words and 987"
 输出: 0
 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 因此无法执行有效的转换。
 示例 5:

 输入: "-91283472332"
 输出: -2147483648
 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 因此返回 INT_MIN (−231) 。
 * created by k
 * 2018/12/4 13:44
 **/
public class 字符串转换整数atoi {

	public static void main(String[] args) {
		String str = " 100000211000000001  x";
		myAtoi(str);
		double maxValue = Double.MAX_VALUE;
		System.out.println(maxValue-1);
	}

	/**
	 * 自己写只能写到切分到数字这步
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {
		if(str==null ){
			return 0;
		}
		str = str.trim();
		int s = 0;
		boolean isNagetive=false;
		if(str.charAt(0)=='-'){
			s= 1;
			str = str.substring(1,str.length());
			isNagetive=true;
			if(!Character.isDigit(str.charAt(1))){
				System.out.println(0);
				return 0;
			}
		}else if(!Character.isDigit(str.charAt(0))){
			System.out.println(0);
			return 0;
		}
		int s1 = 0;
		int s2 = str.length()-1;
		boolean isDigit=false;
		for(int i=s;i<str.length();i++){
			if(!Character.isDigit(str.charAt(i))){
				s2=i;
				break;
			}
			if(i==str.length()-1){
				isDigit=true;
			}
		}
		String number=null;
		if(isDigit){
			number = str.substring(0,str.length());
			if(isNagetive){
				number = "-"+number;
			}
		}else {
			number = str.substring(s1,s2);
			if(isNagetive){
				number = "-"+number;
			}
		}
		//todo 还要继续做


		return 1;
	}

}
