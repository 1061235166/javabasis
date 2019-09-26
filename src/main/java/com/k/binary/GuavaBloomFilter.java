package com.k.binary;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;

/**
 * 布隆过滤器的原理,本身是一个位数组
 * 一开始所有位都为0,此时有n个hash函数,一个数字进入,经过n个hash函数的n次哈希,得出n个下标,给这n个下标的值设置为1
 * 判断此数是否存在,使用n个hash函数再次哈希,查看n个下标的值是否为1,如果都为1,说明此数存在
 * @author k
 * @date 2019/8/2 11:15
 **/
public class GuavaBloomFilter {

	/**
	 *
	 * @author wyk
	 * @date 2019/8/2
	 * @param
	 * @return
	 */
	public static void main(String[] args) {
		//创建一个布隆过滤器,预计元素xxx个,里面默认有5个哈希函数
		BloomFilter<String>filter=BloomFilter.create((from,sink)->{
			sink.putString(from, Charsets.UTF_8);
		},99999999);
		//往过滤器里加元素
		for (int i = 0; i< 919999999; i++) {
			filter.put(i + "");
		}
		//可能包括一个数值
		boolean b = filter.mightContain("11999999");
    	System.out.println(b);
	}
}
