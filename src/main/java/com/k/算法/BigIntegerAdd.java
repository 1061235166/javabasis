package com.k.算法;

import com.google.common.primitives.Ints;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 大整数相加
 * 大于Integer最大值的两个值相加的结果，在不用long或者biginteger的情况下如何计算
 * created by k
 * https://mp.weixin.qq.com/s/GXclPfm_L2kIGAjgLSPX5g
 * 2018/11/21 11:14
 **/
public class BigIntegerAdd {

	public static void main(String[] args) {
		bigIntSum("123","321");

		String big = "123123123123123";
		int []array = new int[big.length()+1];
		for(int i=0;i<big.length();i++){
			char c = big.charAt(big.length() - 1 - i);
			System.out.println(c);
			array[i] = c - '0';
		}
		System.out.println(Arrays.toString(array));
		StringBuilder sb = new StringBuilder();
//		for(int i=array.length-1;i>=0;i++){
//			sb.append(array[i]);
//		}
		System.out.println(sb.toString());
		System.out.println('3'-'0');
		System.out.println((long)Math.pow(2,63));

		BigInteger bigInteger1 = new BigInteger("9223372036854775807");

		System.out.println(bigInteger1.multiply(new BigInteger("2")));

		BigInteger bigInteger2 = new BigInteger("18446744073709551614");
		BigInteger and = bigInteger1.and(bigInteger2);
		System.out.println(and);
		System.out.println(31 & 2);


		System.out.println(31 & 64);

		System.out.println(1+2+4+8+16);
		for(int i=1;;i++){
			double pow = Math.pow(2, i);
//			System.out.println((int)pow);
			System.out.println(Integer.toBinaryString((int)pow)+"_"+i);
			if(i==33){
//				return;
				break;
			}
		}

		System.out.println(Integer.toBinaryString(31));
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(64));
		System.out.println(Integer.toBinaryString(1+2+4+8));
		System.out.println(Integer.toBinaryString(1+2+4+8+16));
		System.out.println(Integer.toBinaryString(1+2+4+8+32-16));

		System.out.println(Integer.toBinaryString(31-2));
		System.out.println(Integer.toBinaryString(31-64));
		System.out.println(Integer.toBinaryString(128-256));


		System.out.println(Integer.toBinaryString(2-31));
		System.out.println(Integer.toBinaryString(2-64));
		System.out.println(Integer.toBinaryString(31%64));
		System.out.println(Integer.toBinaryString(31));
		System.out.println(Integer.toBinaryString(64));
		System.out.println(Integer.toBinaryString(31%2));


		System.out.println(1.6069380442589903e+60);

		BigDecimal ten = new BigDecimal(1.6069380442589903e+60);
		System.out.println(ten.toBigInteger());

		System.out.println(4294967296l | 8589934592l);


		System.out.println("=======================================");

		bigintSum("123123123123123","73821781728371823");
	}

	//思路，使用数组进行计算，把2个数字倒续，从左往右开始计算，每个位相加结果如果大于10，将大于10的部分放到下位里，在下一位的计算中再加上这个数
	public static void bigIntSum(String big1,String big2){
		//检测一下是否是数字，不是会抛出异常
		Integer.parseInt(big1);
		Integer.parseInt(big2);
		//创建一个新数组，长度为两个字符串中最大的一个字符串的长度+1，保证计算后结果不溢出
		int arrayLength = Math.max(big1.length(),big2.length())+1;
		int [] result = new int[arrayLength];
		int [] cs1 = new int[big1.length()];
		int [] cs2 = new int[big2.length()];
		char[] chars1 = big1.toCharArray();
		char[] chars2 = big2.toCharArray();
		for(int i= chars1.length-1;i>=0;i--){
			cs1[i] = chars1[i];
		}
		for(int i= chars2.length-1;i>=0;i--){
			cs2[i] = chars2[i];
		}
		for(int i=0;i<arrayLength-1;i++){
			int i1 = cs1[i];
			int i2 = cs2[i];
			int i3 = i1 + i2;

			if(i3>10){
				result[i+1]=i3- 10;
			}else {
				result[i] = result[i] + i3;
			}
		}
	}

	public static void bigintSum(String big1,String big2){
		System.out.println(big1);
		System.out.println(big2);
		int b1length = big1.length();
		int b2length = big2.length();
		int newLength = Math.max(b1length,b2length)+1;
		System.out.println(b1length);
		int [] newB1 = new int[newLength];
		int index1 = 0;
		for(int i=b1length-1;i>=0;i--){
			newB1[index1++] = big1.charAt(i)-'0'; //- '0'是为了char转int时候
			System.out.print(newB1[index1]);
		}
		System.out.println();
		int index2= 0;
		int [] newB2 = new int[newLength];
		for(int i=b2length-1;i>=0;i--){
			newB2[index2++] = big2.charAt(i)-'0';
			System.out.print(newB2[index2]);
		}

		int [] newA = new int[newLength];
//
		System.out.println();
		System.out.println(newB1.length);
		System.out.println(newB2.length);
		System.out.println();
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for(int i=0;i<newLength-1;i++){
			int a= newB1[i];
			int b= newB2[i];
			if(i!=0){
				isFirst=false;
			}
			//合并
			int sum = a+b;
			if(sum>=10){
				newA[i+1] = 1;
				sum = sum - 10;
			}
			newA[i]=sum;
			if(isFirst && newA[i]==0){
				continue;
			}
			sb.append(newA[i]);
		}
		System.out.println(Arrays.toString(newA));
		System.out.println(sb.reverse().toString());

		BigInteger add = new BigInteger("73821781728371823").add(new BigInteger("123123123123123"));
		System.out.println(add);
		//	123123123123123
		//73821781728371823
		//					51494956
	}
}