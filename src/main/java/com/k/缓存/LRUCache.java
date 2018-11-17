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
			removeHeader();
		}
		if(cache.containsKey(k)){

		}
		addToTail(new Entry(k,v));
		return put;
	}

	public V get(K k){
		V v = cache.get(k);
		addToTail(new Entry(k,v));
		return v;
	}

	public V remove(K k){
		V remove = cache.remove(k);
		removeEntryFromLinkedList(new Entry(k,null));
		return remove;
	}

	private void removeHeader(){
		Entry<K, V> oldHeader = this.header;
		Entry preHeader = oldHeader.next;
		oldHeader = null;
		this.header = preHeader;
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
		entry.pre =oldTail;
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
		for(Entry e = tail;
			!e.equals(header) && header.pre!=null;
			e = e.pre){
			System.out.println(e.k);
		}
	}

	public static void main(String[] args) {
		LRUCache<String,String> lruCache = new LRUCache();
		lruCache.put("1","1");
		lruCache.put("2","2");
		lruCache.put("3","3");
		lruCache.foreachEntryLinkedList();
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
