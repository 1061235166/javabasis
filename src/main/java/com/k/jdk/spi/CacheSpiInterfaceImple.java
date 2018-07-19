package com.k.jdk.spi;

import sun.security.provider.ConfigFile;

/**
 * created by wyk
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
