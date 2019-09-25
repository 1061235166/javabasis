package com.k.jdk.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest {
	public static void main(String[] args) {
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
	private static Stream<String> toStream(){
		return Stream.<String>builder().add("1").add("2").add("3").add("4").build();
	}
}
