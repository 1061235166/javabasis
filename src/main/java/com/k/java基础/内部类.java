package com.k.java基础;

/**
 * created by wyk
 * 2018/10/31
 **/

public class 内部类 {

	private class Inner1{
		static final String a= "123";
		//非静态内部类不能有static方法
//		static void get(){
//
//		}
	}

	static class StaticInner{
		static void get(){}
	}

	public static void main(String[] args) {
		//内部类需要外部类的实例才能被实例化
		Inner1 inner1 = new 内部类().new Inner1();
		//静态内部类不需要外部类的实例化
		StaticInner staticInner = new StaticInner();
	}
}
