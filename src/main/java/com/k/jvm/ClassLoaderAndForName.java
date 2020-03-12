package com.k.jvm;

/**
 * class.forname和classloder.loadclass的区别
 * Created by k on 2020/3/12.
 */
public class ClassLoaderAndForName {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //不会输出com.k.jvm.ClassLoaderAndForName2，类加载器只是加载类
        Class<?> aClass = systemClassLoader.loadClass("com.k.jvm.ClassLoaderAndForName2");
        //会输出com.k.jvm.ClassLoaderAndForName2，除了加载还会初始化类
        Class<?> name = Class.forName("com.k.jvm.ClassLoaderAndForName2");

        Object o = name.newInstance();
        System.out.println(o);

    }

}
class ClassLoaderAndForName2{
    static {
        System.out.println("ClassLoaderAndForName2");
    }
}