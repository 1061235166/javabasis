package com.k.jdk.spi;

/**
 * created by k
 * 2018/7/19
 **/
public class DefaulSpiInterfaceImple implements SpiInterface {
	@Override
	public void out() {
		System.out.println("DefaulSpiInterfaceImple");
	}

	@Override
	public String getCategoryName() {
		return "default";
	}
}
