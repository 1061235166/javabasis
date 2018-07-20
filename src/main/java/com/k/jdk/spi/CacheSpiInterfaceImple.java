package com.k.jdk.spi;


/**
 * created by k
 * 2018/7/19
 **/
public class CacheSpiInterfaceImple implements SpiInterface {
	@Override
	public void out() {
		System.out.println("CacheSpiInterfaceImple");
	}

	@Override
	public String getCategoryName() {
		return "cache";
	}
}
