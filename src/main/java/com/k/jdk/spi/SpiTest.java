package com.k.jdk.spi;

import com.google.common.collect.Lists;

import java.sql.Driver;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * created by wyk
 * 2018/7/19
 **/
public class SpiTest {

	public static void main(String[] args) {
		ServiceLoader<SpiInterface> serviceLoader = ServiceLoader.load(SpiInterface.class);
		for (SpiInterface spiInterface:serviceLoader){
			spiInterface.out();
			System.out.println(spiInterface.getCategoryName());
			System.out.println("========");
		}
		Optional<SpiInterface> first = StreamSupport.stream(serviceLoader.spliterator(), false)
				.filter(spiInterface -> spiInterface.getCategoryName().equals("11")).findFirst();
		System.out.println(first.orElse(new SpiInterface() {
			@Override
			public void out() {
				System.out.println("error");
			}

			@Override
			public String getCategoryName() {
				return "error";
			}
		}));
	}
}
