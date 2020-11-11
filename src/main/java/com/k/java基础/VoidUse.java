package com.k.java基础;

/**
 * 使用void返回方法作为参数
 * Created by k on 2020/3/9.
 */
public class VoidUse {

    public VoidUse(Void use) {
    }

    public static void main(String[] args) {
        new VoidUse(check());
    }

    static Void check(){
        System.out.println("run check");
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        return null;
    }
}
