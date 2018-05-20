package com.k.datastructure.tree;

import java.util.LinkedList;

/**
 * 使用堆栈遍历
 * Created by k on 2018/5/20.
 */
public class StackTraversal {

    public static void inOrderTranserval(Tree<?>tree){
        LinkedList<Tree<?>>stack = new LinkedList();
        while (stack!=null ||!stack.isEmpty()){
            while (tree!=null){
                stack.push(tree);
                tree = tree.getLeft();
            }
            if(!stack.isEmpty()){
                tree = stack.pop();
                System.out.println(tree.getData());
                tree = tree.getRight();
            }
        }
    }

    public static void preOederTraversal(Tree<?>tree){

    }
}
