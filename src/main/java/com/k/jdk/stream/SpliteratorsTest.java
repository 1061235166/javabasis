package com.k.jdk.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author k
 * @date 2019/10/11 09:38
 **/
public class SpliteratorsTest {
	public static void main(String[] args) {

		IntStream intStream = Streams.stream(Lists.newArrayList(1, 2, 3, 4, 5)).mapToInt(Integer::intValue);
		intStream.forEach(System.out::println);
		//不写limit会无限创建对象,直到oom
		List<Integer> collect = Stream.generate(() -> 1)
				.limit(11)
				.collect(Collectors.toList());
    	System.out.println(collect);

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Spliterator<Integer> spliterator = list.spliterator();
    	System.out.println(spliterator.getClass());

		spliterator.forEachRemaining(System.out::println);

		Spliterator<Integer> integerSpliterator = spliterator.trySplit();
		if (integerSpliterator != null) {
			integerSpliterator.forEachRemaining(System.out::println);
		}

		boolean b = spliterator.tryAdvance(
				(s) -> {
					System.out.println(s);
				});
    	System.out.println(b);

    	//Spliterator的特性,使用|赋予特性
		System.out.println(Spliterator.ORDERED );
		System.out.println(Spliterator.SIZED);
		System.out.println(Spliterator.SUBSIZED);
		System.out.println(Spliterator.IMMUTABLE);

    	System.out.println(spliterator.hasCharacteristics(Spliterator.ORDERED));

		Field[] declaredFields = Spliterator.class.getDeclaredFields();
    	System.out.println(declaredFields.length);
		Arrays.stream(declaredFields).filter((field)->{
			boolean r = field.getModifiers() == (Modifier.STATIC | Modifier.FINAL | Modifier.PUBLIC);
			return r;
		}).forEach(System.out::println);
		System.out.println(Modifier.STATIC);
		System.out.println(Modifier.FINAL);
		System.out.println(Modifier.PUBLIC);
		System.out.println(Modifier.STATIC | Modifier.FINAL | Modifier.PUBLIC);

		//特性,去重
		int characterstatics = Spliterator.DISTINCT;
		Spliterator.OfInt ofInt = Spliterators.spliterator(new int[]{1, 2, 3, 4, 5, 6, 7, 2}, characterstatics);
		ofInt.forEachRemaining(new IntConsumer(){

			@Override
			public void accept(int value) {
				System.out.print(value);
			}
		});
	}
}
