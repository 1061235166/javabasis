package com.k.缓存;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * 最近最少使用缓存
 * created by wyk
 * 2018/11/15
 **/
public class LRUCache<K,V>{

	@Deprecated
	private Entry<K,V>header;

	@Deprecated
	private Entry<K,V>tail;

	private HashMap<K,V>cache;

	private int max_size = 100;

	private LinkedList<K>keys = Lists.newLinkedList();

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
			keys.removeFirst();
		}
		if(cache.containsKey(k)){
			cache.remove(k);
		}
		keys.addLast(k);
		return put;
	}

	public V get(K k){
		V v = cache.get(k);
		if(keys.contains(k)){
			keys.remove(k);
		}
		keys.addLast(k);
		return v;
	}

	public V remove(K k){
		V remove = cache.remove(k);
		keys.remove(k);
		return remove;
	}

	private void removeHeader(){
		keys.removeFirst();
	}

	private void addToTail(Entry entry){
//		System.out.println(entry);
		if(header == null && tail == null){
			tail = header = entry;
			header.next=tail;
			tail.pre=header;
			return;
		}
		Entry<K, V> oldTail = this.tail;
		oldTail.next = entry;
		entry.pre = oldTail;
		entry.next=null;
		this.tail=entry;
	}

	private void removeEntryFromLinkedList(Entry entry){
		for(Entry e = tail; !e.equals(entry.k); e = entry.next){
			Object k = entry.k;
			if(k.equals(e.k)){
				Entry a = e.next;
				Entry pre = e.pre;
				pre.next = a;
				a.pre = pre;
				return;
			 }
		}
	}

	private void foreachEntryLinkedList(){
		ListIterator<K> kListIterator = keys.listIterator();
		while (kListIterator.hasNext()){
			System.out.println(kListIterator.next());
		}
	}

	public static void main(String[] args) {
		LRUCache<String,String> lruCache = new LRUCache();
		lruCache.put("1","1");
		lruCache.put("2","2");
		lruCache.put("3","3");
		lruCache.get("1");
		lruCache.get("1");
		lruCache.get("1");
		lruCache.get("4");
		lruCache.foreachEntryLinkedList();

		Map<String,String>map = Maps.newHashMap();
		map.put(null,null);


	}

	class Entry<K,V>{
		Entry next;
		Entry pre;
		K k;
		V v;

		public Entry(K k, V v) {
			this.k = k;
			this.v = v;
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Entry)){
				return false;
			}
			Entry entry = (Entry) obj;
			return entry.k.equals(this.k);
		}

		@Override
		public String toString() {
			return k.toString();
		}
	}

}
