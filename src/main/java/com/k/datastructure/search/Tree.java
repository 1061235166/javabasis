package com.k.datastructure.search;

/**
 * Created by k on 2018/5/20.
 */
public class Tree<T extends Comparable> {
    private Tree left;
    private Tree right;
    private T data;

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
