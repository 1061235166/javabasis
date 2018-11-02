package com.k.binary;

/**
 * Created by k on 2018/6/4.
 */
public class BinaryOperation {

	public static void main(String[] args) {
		rightMove();
//		operationAND();
//		System.out.println("====");
//		operationOR();
		leftMove();
		rightMove();
		stringToBinary();
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
	 * 其实可以左移的结果： a<<b 等价于 a*(b的2次方)
	 */
	public static void leftMove(){

		System.out.println(Integer.toString(1,2));
		//00000000000000000000000000000001		-> 00000000000000000000000000000100
		System.out.println(1<<2);
		System.out.println(Integer.parseInt("00000000000000000000000000000100",2));
		System.out.println(Integer.toBinaryString(2));
		//00000000000000000000000000000010		-> 00000000000000000000000000001000
		System.out.println(2<<2);
		System.out.println(Integer.parseInt("00000000000000000000000000001000",2));
		System.out.println(Integer.toBinaryString(3));
		System.out.println(3<<3);

	}

	/**
	 * >>带符号右移,将数字的二进制格式往右位移n位并舍弃低位的n位，若左操作数是正数，则高位补“0”，若左操作数是负数，则高位补“1”.
	 * * 右移操作
	 *  a >> b 将数值 a 的二进制数值从 0 位算起到第 b - 1 位，整体向右方向移动 b 位，符号位不变，高位空出来的位补数值 0。
	 *  5 >> 1 ===>  1000 0000 0000 0101 >> 1  = 1000 0000 0000 0010 = 2
	 *	7 >> 2 ===>  1000 0000 0000 0111 >> 2  = 1000 0000 0000 0001 = 1
	 *	9 >> 3 ===>  1000 0000 0000 1001 >> 3  = 1000 0000 0000 0001 = 1
	 *	11 >> 2 ===> 1000 0000 0000 1011 >> 2 = 1000 0000 0000 0010 = 2
	 *	a>>b 相当于 a除以b的2次方
	 */
	public static void rightMove(){
		//00000000000000000000000000000001		-> 00000000000000000000000000000000
		System.out.println(1>>2);
		System.out.println(2>>3);
		System.out.println(3>>4);
		System.out.println(0xff>>1);
		System.out.println(Integer.toBinaryString(0xff));

		System.out.println(-1>>2);
	}

	/**
	 * 无符号右移,忽略符号位，空位都以0补齐
	 * >>>
	 */
	public static void unsignedrightMove(){

	}

}
