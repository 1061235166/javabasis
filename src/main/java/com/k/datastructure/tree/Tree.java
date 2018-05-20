package com.k.datastructure.tree;

/**
 * 树的节点
 * Created by wyk on 2018/5/20.
 */
public class Tree<T> {
    //左节点
    private Tree<T> left;
    //右节点
    private Tree<T> right;
    //数据
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }
}
