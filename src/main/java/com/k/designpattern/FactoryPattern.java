package com.k.designpattern;

/**
 * 工厂模式
 * 工厂模式的好处：
 * 1.将对象的创建和使用分开
 * 2.屏蔽对象复杂的构造方法
 * 3.降低维护成本，如果修改对象的创建方式的话，可以做到在一处修改，所有被调用的地方都得到修改的特点
 * created by wyk
 * 2018/9/5
 **/
public class FactoryPattern {
	public static void sinpleFactoryPattern(){

	}
}

interface Car{
	void carName();
}

class Toyota implements Car{
	@Override
	public void carName() {
		System.out.println("丰田");
	}
}

class BWM implements Car{
	@Override
	public void carName() {
		System.out.println("宝马");
	}
}

class Dongfeng implements Car{
	@Override
	public void carName() {
		System.out.println("东风小康");
	}
}
//简单工厂模式，缺点是每次新增类都要添加新的分支
//还可以用反射实现简单工厂
class SimpleFactory{

	public static Car getCar(String name){
		if(name == null){
			return null;
		}
		if(name.equals("df")){
			return new Dongfeng();
		}else if(name.equals("toyota")){
			return new Toyota();
		}else if(name.equals("bwm")){
			return new BWM();
		}
		return null;
	}
}
//抽象工厂至少生产两个以上的产品，工厂方法只能生成一个产品
interface CarFactory{
	Car createCar();
}

//工厂方法
class BWMFactory implements CarFactory{
	@Override
	public Car createCar() {
		return new BWM();
	}
}
class DongfengFactory implements CarFactory{
	@Override
	public Car createCar() {
		return new Dongfeng();
	}
}

//抽象工厂方法，引入了产品组的概念，一个工厂可以生成多个产品
//轮胎
interface Tire{
	void getTire();
}
//玻璃
interface Glass{
	void getGlass();
}

class BWMTire implements Tire{
	@Override
	public void getTire() {
		System.out.println("宝马轮胎");
	}
}

class BWMGlass implements Glass{

	@Override
	public void getGlass() {
		System.out.println("宝马玻璃");
	}
}

class DongfengTire implements Tire{
	@Override
	public void getTire() {
		System.out.println("东风轮胎");
	}
}

class DonfengGlass implements Glass{

	@Override
	public void getGlass() {
		System.out.println("东风玻璃");
	}
}

interface AbstractCarFactory{

	Tire getTire();

	Glass getGlass();
}

class BWMCarFactory implements AbstractCarFactory{

	@Override
	public Tire getTire() {
		return new BWMTire();
	}

	@Override
	public Glass getGlass() {
		return new BWMGlass();
	}

	public static void main(String[] args) {
		AbstractCarFactory factory = new BWMCarFactory();
		Glass glass = factory.getGlass();
		Tire tire = factory.getTire();
	}
}

class DonfengFactory implements AbstractCarFactory{

	@Override
	public Tire getTire() {
		return new DongfengTire();
	}

	@Override
	public Glass getGlass() {
		return new DonfengGlass();
	}

	public static void main(String[] args) {
		AbstractCarFactory factory = new DonfengFactory();

		Glass glass = factory.getGlass();
		Tire tire = factory.getTire();

	}
}
