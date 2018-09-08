package com.k.jdk.optional;

import java.util.Optional;

/**
 * 使用optional消除空指针异常
 * created by wyk
 * 2018/7/27
 **/
public class OptionalTest1 {

	public static void main(String[] args) {
		Optional<Object> empty = Optional.empty();
		System.out.println(empty.isPresent());
		String a= null;
		String s = Optional.ofNullable(a).orElse("11111");
		System.out.println(s);

		String s1 = Optional.ofNullable(a).orElseGet(() -> {
			return "abc".toUpperCase();
		});
		System.out.println(s1);

		String s3 = Optional.ofNullable(a).map((s2) -> {
			return "2222".toUpperCase();
		}).orElse("333");

		System.out.println(s3);

		String s4 = Optional.ofNullable("").filter((s2) -> {
			return true;
		}).get();

		System.out.println(s4);


		Optional<String> op = Optional.ofNullable(a);

		boolean equals = op.equals(Optional.empty());


		System.out.println(equals);


	}
}
