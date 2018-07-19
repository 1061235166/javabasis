package com.k.jdk.spi;

/**
 * created by wyk
 * 2018/7/19
 **/
public class SystemSpiInterfaceImple implements SpiInterface {

	@Override
	public void out() {
		System.out.println("SystemSpiInterfaceImple");
	}

	@Override
	public String getCategoryName() {
		return "system";
	}
}
