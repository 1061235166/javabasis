package com.k.datastructure.tree;

/**
 * Created by k on 2018/11/22.
 */
public class BST <K extends Comparable<K>,V> implements TreeOperation<K,V> {

    private Node root;

    @Override
    public V get(K k) {
        return get(root,k);
    }

    private V get(Node node,K k){
        if(node ==null){
            return null;
        }
        int i = k.compareTo(node.k);
        if(i==0){
            return node.v;
        }
        if(i<0){
            Node left = node.left;
            return get(left,k);
        }
        Node right = node.right;
        return get(right,k);
    }

    @Override
    public void put(K k, V v) {
        put(root,k,v);
    }

    private Node put(Node node,K k,V v){
        if(node == null){
            return new Node(k,v,null,null);
        }
        int i = node.k.compareTo(k);
        if(i<0){
            node.left = put(node.left,k,v);
        }
        if(i>0){
            node.right = put(node.right,k,v);
        }
        if(i==0){
            node.k=k;
            node.v=v;
        }
        return node;
    }

    private class Node{
        private K k;
        private V v;
        private Node left;
        private Node right;

        public Node(K k, V v, Node left, Node right) {
            this.k = k;
            this.v = v;
            this.left = left;
            this.right = right;
        }
    }
}
