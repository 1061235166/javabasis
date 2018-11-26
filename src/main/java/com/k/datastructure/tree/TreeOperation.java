package com.k.datastructure.tree;

/**
 * Created by k on 2018/11/22.
 */
public interface TreeOperation<K,V> {
    V get(K k);


    void put(K k,V v);
}
