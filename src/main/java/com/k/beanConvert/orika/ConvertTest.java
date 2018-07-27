package com.k.beanConvert.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * created by wyk
 * 2018/7/27
 **/
public class ConvertTest {

	public static void main(String[] args) {
		Origin origin = new Origin();
		origin.setAddress("hz");
		origin.setAge(1);
		origin.setPrice(1.2f);
		origin.setName("java");

		DefaultMapperFactory build = new DefaultMapperFactory.Builder().build();
		MapperFacade mapperFacade = build.getMapperFacade();
		Dest map = mapperFacade.map(origin, Dest.class);
		System.out.println(map.getAddress());
		System.out.println(map.getAge());
		System.out.println(map.getName());
		System.out.println(map.getPrice());
		//需要测试一下他和spring beanutil.copyproperties的效率
	}
}
