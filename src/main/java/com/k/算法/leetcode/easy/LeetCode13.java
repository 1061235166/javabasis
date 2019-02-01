package com.k.算法.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @author k
 * @date 2018/12/12 09:51
 **/
public class LeetCode13 {

	public static void main(String[] args) {
//		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));

		System.out.println("1234".substring(0,2));
	}


	/**
	 * 自己的解法
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		Map<String,Integer>map =new HashMap<>();
		map.put("I",1);
		map.put("V",5);
		map.put("X",10);
		map.put("L",50);
		map.put("C",100);
		map.put("D",500);
		map.put("M",1000);
		map.put("IV",4);
		map.put("IX",9);
		map.put("XL",40);
		map.put("XC",90);
		map.put("CD",400);
		map.put("CM",900);

		StringBuilder sb = new StringBuilder(s);

		boolean contains = map.keySet().contains(s);
		if(contains){
			return map.get(s);
		}

		int num = 0;
		while (sb.length()>0){
			if(sb.length()>=2){//防止stringbuilder长度还剩1的时候出现错误
				String start = sb.substring(0, 2);
				Integer integer = map.get(start);
				if(integer!=null){
					num+=integer;
					sb.delete(0,2);
					continue;
				}
				start = sb.substring(0,1);
				integer = map.get(start);
				if(integer!=null){
					num+=integer;
					sb.deleteCharAt(0);
					continue;
				}
			}
			String start = sb.substring(0,1);
			Integer integer = map.get(start);
			if(integer!=null){
				num+=integer;
				sb.deleteCharAt(0);
				continue;
			}
		}
		return num;
	}

	/**
	 * 网上的解法
	 * @param s
	 * @return
	 */
	public static int romanToInt2(String s) {
		if (s == null || s.length() == 0)
			return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int len = s.length(), result = map.get(s.charAt(len - 1));
		for (int i = len - 2; i >= 0; i--) {
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
				result += map.get(s.charAt(i));
			else
				result -= map.get(s.charAt(i));
		}
		return result;
	}
}
