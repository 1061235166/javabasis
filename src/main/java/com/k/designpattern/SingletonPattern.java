package com.k.designpattern;

/**
 * 单例模式
 * 满足几个条件
 * 1.构造方法私有
 * 2.实例必须是static的，那样才能保证只有一个实例
 * 好处：对于频繁使用的对象，可以减少new的次数，节省内存空间
 * created by wyk
 * 2018/9/5
 **/
public class SingletonPattern {
	public static void main(String[] args) {
		System.out.println(Singleton1.getInstance());
		System.out.println(Singleton2.getSingleton2());
		System.out.println(Singleton3.getSingleton3());
		System.out.println(Singleton4.getSingleton4());
	}
}
//饿汉
class Singleton1{
	private Singleton1(){
		System.out.println("Singleton1");
	}

	private static Singleton1 instance = new Singleton1();

	public static Singleton1 getInstance(){
		System.out.println("instance");
		return instance;
	}
}
//懒汉
class Singleton2{
	private Singleton2(){

	}

	private static Singleton2 singleton2;

	public static Singleton2 getSingleton2(){
		//线程不安全
		if(singleton2 ==null){
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}
//懒汉，线程安全
class Singleton3{
	private Singleton3(){
		System.out.println("singleton3");
	}

	private static Singleton3 singleton3;

	private static class SingleHolder{
		static Singleton3 singleton3 = new Singleton3();
	}
	//只有在调用了getSingleton3方法后才会触发singletonholder实例化
	public static Singleton3 getSingleton3(){
		return SingleHolder.singleton3;
	}
}

//饿汉，线程安全
class Singleton4{
	private Singleton4(){

	}

	private volatile static Singleton4 singleton4;

	public static Singleton4 getSingleton4(){
		if(singleton4 == null){
			synchronized (Singleton4.class){
				singleton4 = new Singleton4();
			}
		}
		return singleton4;
	}
}

//饿汉，线程安全
enum Singleton5{
	SINGLETON_5;

	public Singleton5 getSingleton5(){
		return SINGLETON_5;
	}
}