package com.k.jdk.collection;

import com.google.common.collect.Sets;

import java.util.HashSet;

/**
 * @author wyk
 * @date 2019/11/19 11:43
 **/
public class CollectionRemove {

	public static void main(String[] args) {
		removeAll();
	}

	static void removeAll(){
		HashSet<Integer> set = Sets.newHashSet(1, 2, 3, 4, 5);
		HashSet<Integer> set2 = Sets.newHashSet(1,3,6,7,8);
		set.removeAll(set2);
		System.out.println(set);
		System.out.println(set2);
	}
}
