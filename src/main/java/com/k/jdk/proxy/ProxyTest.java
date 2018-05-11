package com.k.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by k on 2018/5/11.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Eat eat = (Eat) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{Eat.class}, new ManProxy(new Man()));
        eat.eat();
    }
}
interface Eat{
    void eat();
}
class Man implements Eat{

    public void eat() {
        System.out.println("这饭真香");
    }
}