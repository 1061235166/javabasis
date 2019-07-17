package com.k.jvm;

/**
 * 自定义类加载器
 * @author wyk
 * @date 2019/7/8 14:48
 **/
public class MyClassLoader extends ClassLoader {

	/**
	 * 自定义类加载器,
	 * @author wyk
	 * @date 2019/7/8
	 * @param
	 * @return
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> aClass = Class.forName(name);
		return aClass;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> aClass = Class.forName("java.lang.String", true, new MyClassLoader());
    	System.out.println(aClass);
	}
}
