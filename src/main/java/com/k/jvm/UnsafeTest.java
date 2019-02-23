package com.k.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wyk
 * @date 2019/2/22 14:22
 **/
public class UnsafeTest {

	public static void main(String[] args) {
		Unsafe unsafe = getUnsafe();
		System.out.println(unsafe);
		/**
		 * unsafe包含的操作分类
		 *
		 * 1.分配内存
		 * 2.对数据的原子操作
		 * 3.内存屏障
		 * 4.线程的挂起和恢复
		 * 5.对象实例化
		 * 6.线程同步
		 * 7.数组操作
		 *
 		 */
	}

	public static Unsafe getUnsafe(){
//		return Unsafe.getUnsafe(); 这种方式会报错,
//		if (!VM.isSystemDomainLoader(var0.getClassLoader())) {
//			throw new SecurityException("Unsafe");
//		}
		//必须使用反射获取unsafe
		try {
			Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
			try {
				unsafe.setAccessible(true);
				Object o = unsafe.get(Unsafe.class);
				return (Unsafe) o;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}
}
