package com.k.算法;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/**
 * 中位数:
 * @author k
 * @date 2019/8/2 11:21
 **/
public class 海量数据查找中位数 {

	/**
	 * 原题url
	 * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247485123&idx=1&sn=118f7f665b902b924e949b01d76d7a25&chksm=fa0e6942cd79e054eaa763aca52efc3d25248abf00b7fcb4620b0bafc04f98230b1672f8fad6&scene=0&xtrack=1&key=41320631896c4008c1edb9808600feb428f06513e1c38fe02710634b6792f27918bbb08735e3e3ea84e9ca300957024107795849add1115a8eddacb681ce1628b1ecc006d91dbca15db410f7dde69afb&ascene=1&uin=MTg1ODkzNTkyMg%3D%3D&devicetype=Windows+10&version=62060739&lang=zh_CN&pass_ticket=3TXWJXviPtfLGQ%2BwN%2FCbu8Gh0fhSVxPCm3cvntrDN%2FtZ0Fu6tL1xrMKha479eL7O
	 * @author k
	 * @date 2019/8/2
	 * @param
	 * @return
	 */
	public static void main(String[] args) {
		BloomFilter<Integer>filter=BloomFilter.create(new Funnel<Integer>() {
			@Override
			public void funnel(Integer from, PrimitiveSink into) {
				into.putInt(from);
			}
		},21111);
		long l = filter.approximateElementCount();
    	System.out.println(l);
	}
}
