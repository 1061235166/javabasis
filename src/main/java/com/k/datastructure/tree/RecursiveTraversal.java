package com.k.datastructure.tree;

/**
 * 递归遍历
 * 对每个子树都进行根-》左-》右这样的顺序遍历
 * 不管怎么遍历，都是从左中开始，不会从右边开始
 * Created by k on 2018/5/20.
 */
public class RecursiveTraversal {
    public static void main(String[] args) {

    }

    /**
     * 递归遍历
     */
    private static void prerecursiveTraversal(Tree<?> tree){
        if(tree!=null){
            System.out.println(tree.getData());
            prerecursiveTraversal(tree.getLeft());
            prerecursiveTraversal(tree.getRight());
        }
    }

    public static void inrecursiveTraversal(Tree<?> tree){
        if(tree!=null){
            inrecursiveTraversal(tree);
            System.out.println(tree.getData());
            inrecursiveTraversal(tree);
        }
    }

    public static void postrescursiveTraversal(Tree<?> tree){
        if(tree!=null){
            inrecursiveTraversal(tree);
            inrecursiveTraversal(tree);
            System.out.println(tree.getData());
        }
    }
}
