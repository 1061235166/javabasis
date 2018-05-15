package com.k.jdk.stream;

import java.util.stream.IntStream;

/**
 * Created by wyk on 2018/5/12.
 */
public class IntStreamTest {

    public static void main(String[] args) {
        long count = IntStream.range(0, 10).count();
        System.out.println(count);

        double asDouble = IntStream.range(0, 101).average().getAsDouble();
        System.out.println(asDouble);
    }
}
