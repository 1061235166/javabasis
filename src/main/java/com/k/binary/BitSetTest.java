package com.k.binary;

import java.util.BitSet;

/**
 * java.util bitmap，和redis的***bit()操作类似，用来操作位数据
 * created by wyk
 * 2018/10/29
 **/
public class BitSetTest {

	public static void main(String[] args) {
		BitSet bitSet = new BitSet();

		bitSet.set(0,0);
		System.out.println(bitSet.cardinality());

		bitSet.flip(0);

		boolean b = bitSet.get(0);
		//反转当前位数据
		bitSet.flip(0);

		b = bitSet.get(0);
		System.out.println(b);
	}



}
