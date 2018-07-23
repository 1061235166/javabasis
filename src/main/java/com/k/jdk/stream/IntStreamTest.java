package com.k.jdk.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * Created by k on 2018/5/12.
 */
public class IntStreamTest {

    public static void main(String[] args) {
		arrayStream();
    }

    public static void arrayStream(){
		OptionalDouble average = Arrays.stream(new int[]{1, 2, 3, 4, 5}).average();
		System.out.println(average.getAsDouble());
	}
}
