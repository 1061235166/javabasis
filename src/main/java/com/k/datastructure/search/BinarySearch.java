package com.k.datastructure.search;

/**
 * 二分查找，前提这个二叉树是个二叉搜索树
 * Created by k on 2018/5/20.
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

    public static Tree<Integer> search(int e,Tree<Integer> tree){
        while (tree != null){
            if(tree.getData().compareTo(e)>0){
                return search(e,tree.getLeft());
            }else if(tree.getData().compareTo(e)<0){
                return search(e,tree.getRight());
            }else {
                return tree;
            }
        }
        return null;
    }
}
