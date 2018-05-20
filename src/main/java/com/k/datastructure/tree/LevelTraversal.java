package com.k.datastructure.tree;

import java.util.LinkedList;

/**
 * 用队列进行层序遍历
 * Created by k on 2018/5/20.
 */
public class LevelTraversal {


    public static void main(String[] args) {
        levelTraversal(null);
    }

    public static void levelTraversal(Tree tree){
        LinkedList<Tree> queue = new LinkedList();
        queue.add(tree);
        while (!queue.isEmpty()){
            Tree pop = queue.pop();
            System.out.println(pop.getData());
            if(pop.getLeft()!=null){
                queue.add(pop.getLeft());
            }
            if(pop.getRight()!=null){
                queue.add(pop.getRight());
            }
        }
    }
}
