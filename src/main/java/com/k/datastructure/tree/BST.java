package com.k.datastructure.tree;

/**
 * Created by k on 2018/11/22.
 */
public class BST <K extends Comparable<K>,V>   {

    private Node root;

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node ==null)
            return 0;
        return node.n;
    }

    public V get(K k){
        return get(root,k);
    }

    private V get(Node node,K k){
        if(node == null){
            return null;
        }
        if(k.compareTo(node.k)==0){
            return node.v;
        }
        if(k.compareTo(node.k)<0){
            return get(node.left,k);
        }
        return get(node.right,k);
    }

    public void put(K k,V v){
        put(root,k,v);
    }

    private Node put(Node node,K k,V v){
        if(node == null){
            return new Node(k,v,1);
        }
        if(k.compareTo(node.k)<0){
            return put(node.left,k,v);
        }
        else if(k.compareTo(node.k)<0){
            return put(node.right,k,v);
        }else {
            node.v = v;
            node.n = size(node.left)+size(node.right);
        }
        return node;
    }


    private class Node{
        private K k;
        private V v;
        private int n;
        private Node left;
        private Node right;
        public Node(K k, V v, int n) {
            this.k = k;
            this.v = v;
            this.n = n;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(11,2);
        bst.put(5,2);
        bst.put(7,2);
        bst.put(9,2);
        bst.put(13,2);
        bst.put(16,2);
        Object o = bst.get(5);
        System.out.println(o);
        System.out.println(bst.size());
    }
}
