package com.k.缓存;


import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 最近最少使用缓存
 * created by wyk
 * 2018/11/15
 **/
public class LRUCache<K,V>{

	private Entry<K,V>header;

	private Entry<K,V>tail;

	private HashMap<K,V>cache;

	private int max_size = 100;

	public LRUCache(){
		this.cache = new HashMap<>(100);
	}

	public LRUCache(int maxSize){
		this.max_size= maxSize;
		this.cache = new HashMap<>(maxSize);
	}

	private V put(K k,V v){
		V put = cache.put(k, v);
		if(cache.size()>=max_size){


		}
		return put;
	}

	private void movetoLast(Entry entry){

	}

	private void append(K k,V v){
		Entry entry =new Entry();
		entry.k=k;
		entry.v=v;
		entry.next=null;
		entry.pre=tail;
		tail = entry;
	}

	private void removeHeader(Entry entry){

	}

	public static void main(String[] args) {
//		double ceil = Math.ceil(1.1f);
//		System.out.println(ceil);
//		System.out.println(Math.ceil(1.6));
//		System.out.println(Math.floor(1.1));
//		System.out.println(Math.floor(1.9));
//		new LinkedHashMap<String,String>(10,0.75f,true);
//
//		long a= 4294967296l;
//		System.out.println(Long.MAX_VALUE>a);
//		System.out.println(Long.MAX_VALUE+1);

		long r=0;

		for(int i=0;i<48;i++){
			double pow = Math.pow(2, i);
			long l = Double.valueOf(pow).longValue();
			r = r|l;
			System.out.println(r);
		}
		System.out.println(r);
		System.out.println(4294967296l | 8589934592l);
	}

	class Entry<K,V>{
		Entry next;
		Entry pre;
		K k;
		V v;
	}

}
