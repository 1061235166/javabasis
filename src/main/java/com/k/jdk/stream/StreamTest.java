package com.k.jdk.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest {


	public static void main(String[] args) {
		listToMapDistinct();
	}

	static void streamMapAndCollect(){
		//创建stream
		Stream<String> stream = toStream();
		//转换成list<Long>类型
		List<Long> collect = stream.map(Long::parseLong).collect(Collectors.toList());
		System.out.println(collect);

		stream = toStream();
		//转换为set
		Set<String> set = stream.collect(Collectors.toSet());
		System.out.println(set);

		//使用tomap转换为map
		stream = toStream();
		Map<Long, String> map = stream.collect(Collectors.toMap(Long::parseLong, Function.identity()));
		System.out.println(map);

		//单线程循环
		stream = toStream();
		stream.forEachOrdered(System.out::println);
		stream = toStream();
		stream.forEach(System.out::println);

		//多线程循环,可能无序
		stream = toStream();
		Stream<String> parallel = stream.parallel();
		parallel.forEach(System.out::println);
	}

	/**
	 * 创建一个stream
	 * @return
	 */
	static Stream<String> toStream(){
		return Stream.<String>builder().add("1").add("2").add("3").add("4").build();
	}

	static Stream<Integer> toIntStream(){
		return Stream.<Integer>builder().add(1).add(2).add(3).add(4).build();
	}

	static void reduce(){
		Stream<String> stream = toStream();
		String s = stream.reduce(String::concat).get();
    	System.out.println(s);

		stream = toStream();
		String s1 = stream.reduce((a, b) -> a + b).get();
    	System.out.println(s1);

		Stream<Integer> integerStream = toIntStream();
		//起始值为1
		Integer reduce = integerStream.reduce(1, Integer::sum);
    	System.out.println(reduce);

	}

	/**
	 * 多个流合并成一个流
	 */
	static void flatMap(){
		Stream<String> stringStream = toStream();
		Stream<Object> stream = stringStream.flatMap(new Function<String, Stream<?>>() {
			@Override
			public Stream<Integer> apply(String s) {
				return Lists.newArrayList(1,2,3,4,5,Integer.parseInt(s)).stream();
			}
		});
		stream.forEach(System.out::println);

		/**
		 * 换一种写法
		 */
		toStream()
				.flatMap((s)->Lists.newArrayList(3,4,5,6,7,Integer.parseInt(s)).stream())
				.forEach(System.out::println);
	}

	static void listToMapDistinct(){
		ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10);
		//Exception in thread "main" java.lang.IllegalStateException: Duplicate key 10
		//直接用toMap会报错
//		try {
//			Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap((k) -> k, (v) -> v));
//			System.out.println(collect);
//		}catch (Exception e){
//			e.printStackTrace();
//		}

		//使用Bifunction处理重复的key
		Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap((k) -> k, Function.identity(), (a, b) -> {
			System.out.println(a);
			System.out.println(b);
			return a+b;
		}));
		System.out.println(collect);
	}
}
