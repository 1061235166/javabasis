package com.k.binary;

import java.math.BigInteger;

/**
 * 总结:
 * 二进制左移一位，其实就是将数字翻倍
 * 二进制右移一位，就是将数字除以 2 并求整数商的操作
 *
 * 左移:去除最高位n位,右边用0补
 * 右移:去除最低位n为,左边用0补,是正数最高位用0补,负数最高位用1补
 * 无符号右移:去除最低位n位,左边用0补
 * 进制表示规范
 这个小节是插曲，部分同学可能注意到上面写的进制定义是：0b01011000，部分同学 可能疑惑为什么不是 0x 之类的。
 前缀
 十进制：直接写数字即可
 二进制：0b或0B开头；如：0b01011000 代表十进制 88
 八进制：0 开头；如：0130 代表十进制 88 （1x64+3x8）
 十六进制：0x或0X开头；如：0x58 代表 88 (5x16+8)
 后缀
 0x?? 若小于127 则按byte算，大于则按int类型算
 0xFF默认为int类型
 若声明为long添加后缀：L或l：如：0xFFL 或 0xFFl
 带小数的值默认为double类型；如：0.1
 若声明为float添加后缀：f 或 F：如：0.1F
 若声明为double添加后缀：d或D：如：1D
 范围
 二进制：1、0
 八进制：0～7
 十进制：0～9
 十六进制：0～9 + A～F

 * Created by k on 2018/6/4.
 */
public class BinaryOperation {


	/**
	 *
	 * @author k
	 * @date 2019/1/26
	 * @param
	 * @return
	 */
	public static void main(String[] args) {
//		rightMove();
//		operationAND();
//		System.out.println("====");
//		operationOR();
//		leftMove();
//		rightMove();
//		stringToBinary();
//		unsignedrightMove();
		binaryForBiginteger();

	}

	public static void stringToBinary(){
		String key = "king";
		StringBuilder sb = new StringBuilder();
		for(char c : key.toCharArray()){
			int i = c;
			System.out.println(i);
			String s = Integer.toBinaryString(i);
			System.out.println(s);
			sb.append(s).append(" ");//高位0不显示
		}
		System.out.println(sb.toString());
	}

	/**
	 * 按位与，两个二进制数字进行对比，从最高位到最低位一一对应，如果对应的位的值都是1，结果就是1，否则是0
	 */
	public static void operationAND(){
		String s = Integer.toBinaryString(100);
		String s1 = Integer.toBinaryString(5001);
		System.out.println(s);
		System.out.println(s1);
		int r = 100 & 5001;
		System.out.println(r);
		System.out.println(Integer.toBinaryString(r));
	}

	/**
	 * 按位或，两个二进制数字进行对比，从最高位到最低位一一对应，如果对应的位只要有一个为1，结果就是1，否则是0
	 */
	public static void operationOR(){
		String s = Integer.toBinaryString(100);
		String s1 = Integer.toBinaryString(5001);
		System.out.println(s);
		System.out.println(s1);
		int r = 100 | 5001;
		System.out.println(r);
		System.out.println(Integer.toBinaryString(r));
	}

	/**
	 * 取反，每位值位1取0，为0取1
	 */
	public static void bitInversion(){
		String s = Integer.toBinaryString(321);
		System.out.println(s);
		int r = (~321);
		System.out.println(Integer.toBinaryString(r));
	}

	/**
	 * 按位异或(^)，两个二进制数字进行对比，对于同一位上，如果数值相同则为 0，数值不同则为 1
	 * 3 ^ 5 = 6,而 6 ^ 5 = 3，所以异或可以做简单的加密解密操作
	 */
	public static void operationXOR(){
		String a = Integer.toBinaryString(21);
		String b = Integer.toBinaryString(24);
		System.out.println(a);
		System.out.println(b);
		System.out.println(21 ^ 24);

	}


	/**
	 * 左移，将数字的二进制格式往左位移n为并舍弃高位的n位，低位用0补上
	 * 其实可以左移的结果： a<<b 等价于 a*(2的b次方)
	 *
	 */
	public static void leftMove(){
		System.out.println("========leftMove start========");
		System.out.println(Integer.toString(1,2));
		//00000000000000000000000000000001		-> 00000000000000000000000000000100
		System.out.println(1<<2);
		System.out.println(Integer.parseInt("00000000000000000000000000000100",2));
		System.out.println(Integer.toBinaryString(2));
		//00000000000000000000000000000010		-> 00000000000000000000000000001000
		System.out.println(2<<2);
		System.out.println(Integer.parseInt("00000000000000000000000000001000",2));
		System.out.println(Integer.toBinaryString(3));
		System.out.println(3<<3);//3*2^3
		System.out.println(-3<<3);
		System.out.println("========leftMove end========");
	}

	/**
	 * >>带符号右移,将数字的二进制格式往右位移n位并舍弃低位的n位，若左操作数是正数，则高位补“0”，若左操作数是负数，则高位补“1”.
	 * * 右移操作
	 *  a >> b 将数值 a 的二进制数值从 0 位算起到第 b - 1 位，整体向右方向移动 b 位，符号位不变，高位空出来的位补数值 0。
	 *  5 >> 1 ===>  1000 0000 0000 0101 >> 1  = 1000 0000 0000 0010 = 2
	 *	7 >> 2 ===>  1000 0000 0000 0111 >> 2  = 1000 0000 0000 0001 = 1
	 *	9 >> 3 ===>  1000 0000 0000 1001 >> 3  = 1000 0000 0000 0001 = 1
	 *	11 >> 2 ===> 1000 0000 0000 1011 >> 2 = 1000 0000 0000 0010 = 2
	 *	a>>b 相当于 a除以2的b次方
	 */
	public static void rightMove(){
		System.out.println("========rightMove end========");
		//00000000000000000000000000000001		-> 00000000000000000000000000000000
		System.out.println(1>>2);
		System.out.println(2>>3);
		System.out.println(3>>4);
		System.out.println(0xff>>1);
		System.out.println(Integer.toBinaryString(0xff));

		System.out.println(-1>>2);
		System.out.println(100>>3);
		System.out.println("========rightMove end========");
	}

	/**
	 * 无符号右移,忽略符号位，空位都以0补齐
	 * >>>
	 */
	public static void unsignedrightMove(){
		System.out.println("unsignedrightMove start");
		//01无符号右移1位是0
		System.out.println(1>>>1);

		System.out.println(100>>>2);
		System.out.println(-100>>>2);
		System.out.println(Integer.MAX_VALUE>>>1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println("unsignedrightMove end");
	}

	/**
	 * 用bigint转换
	 */
	public static void binaryForBiginteger(){
		BigInteger bigInteger = new BigInteger("32");
		String s = bigInteger.toString(2);
		System.out.println(s);

		int a = 32 <<1;
		System.out.println(a);
		BigInteger b = new BigInteger(a+"");
		System.out.println(b.toString(2));
		System.out.println(Integer.parseInt(b.toString(2),10));
	}
}