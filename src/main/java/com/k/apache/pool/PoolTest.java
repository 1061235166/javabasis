package com.k.apache.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wyk
 * @date 2019/12/5 15:39
 **/
public class PoolTest {

	public static void main(String[] args) throws Exception {
		pool1();
	}

	static void pool1() throws Exception {
		AtomicInteger i = new AtomicInteger(1);
		GenericObjectPool<String>pool = new GenericObjectPool<String>(new BasePooledObjectFactory<String>(){
			@Override
			public String create() throws Exception {
				return i.getAndIncrement()+"";
			}

			@Override
			public PooledObject wrap(String obj) {
				return new DefaultPooledObject(obj);
			}
		});

		String s = pool.borrowObject();
	    System.out.println(s);
		s = pool.borrowObject();
		System.out.println(s);

		pool.returnObject("1");
		pool.returnObject("2");
		pool.returnObject("3");
		s = pool.borrowObject();
		System.out.println(s);
	}



}
