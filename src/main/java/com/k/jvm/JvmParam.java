package com.k.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.Executors;

/**
 * created by wyk
 * 2018/9/17
 **/
public class JvmParam {


	public static void main(String[] args) throws InterruptedException {

	}
	//-Xms1024k -Xmx1025k，初始化内存1024kb，最大1024kb
	public static void oom(){
		byte[]bs=new byte[1024*1025];//1025kb，超过了堆内存最大限制，抛出异常java.lang.OutOfMemoryError: Java heap space
		int index = 0;
		for(;index<bs.length-1;index++){
			bs[index]=11;
		}
	}


}
