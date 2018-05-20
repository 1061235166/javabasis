package com.k.datastructure.search;

/**
 * 二分查找
 * Created by k on 2018/5/20.
 */
public class BinrySearch {

    public static void main(String[] args) {

    }

    public static  Tree<Integer> search(int e,Tree<Integer> tree){
        while (tree != null){
            if(tree.getData()>e){
                return search(e,tree.getLeft());
            }else if(tree.getData()<e){
                return search(e,tree.getRight());
            }else {
                return tree;
            }
        }
        return null;
    }
}
