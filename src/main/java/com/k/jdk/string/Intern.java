package com.k.jdk.string;

/**
 * String.inten：返回一个equals为true的字符串，而且能保证从常量池中返回一个唯一的字符串
 * 如果常量池没有这个字符串，就将其放入常量池并返回。
 * 一般来说，能在编译期确定的字面量字符串都能被加入到常量池中，有些特殊的字符串也会被自动加入到
 * 常量池中，比如java
 * Created by k on 2018/6/14.
 */
public class Intern {
    public static final String oldacar = "老爷车";

    public static void main(String[] args) {
        String car = new String("老爷车");
        //新new的对象和常量池的对象对比
        System.out.println(car == oldacar);
        //从常量池获取equals老爷车为true的字符串，而老爷车已经存在于常量池了
        System.out.println(car.intern() == oldacar);
        String java = new String("java");
        //从常量池获取equals java为true的字符串，而java已经存在于常量池了
        System.out.println(java.intern()  == "java" );
        System.out.println(java.intern()  == java );
        //字面量，飞机进入常量池
        String fly = "飞机";
        //从常量池获取飞机，而常量池已经存在于飞机了
        System.out.println(new String("飞机").intern() == fly);
        //在编译期就能确定了 TODO 这个还不是很确定
        System.out.println("飞机" == fly);

        String s = new StringBuilder("jav").append("a").toString();
        System.out.println(s.intern()==s);
    }
}
