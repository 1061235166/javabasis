package com.k.jdk.functional;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

/**
 *
 *
 * created by k
 * 2018/5/11
 **/
public class StreamSupportTest {


    public static void main(String[] args) {
		numberStream();
    }

    public static void parallel(){
		List<?> integers = Lists.newArrayList(1,213,45,90,56,6);
		//parallel:false，按照迭代器的顺序组成一个流
		StreamSupport.stream(integers.spliterator(),false).forEach(t-> System.out.println(t));

		System.out.println("===");

		//parallel:true，不按照迭代器的顺序组成一个流，是不是随机的不好说
		StreamSupport.stream(integers.spliterator(),true).forEach(t-> System.out.println(t));
	}

	public static void numberStream(){
//		int concurrent = Spliterator.OfInt.CONCURRENT;
//		StreamSupport.intStream()
		ArrayList<String> list = new ArrayList(Arrays.asList("a", "b", "c", "d"));
		for (String s : list) {
			if (s.equals("a"))
				list.remove(s);
		}
	}
}
