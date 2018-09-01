package com.k.designPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式
 * 代理模式在java里的应用一般为aop
 * Created by k on 2018/8/25.
 */
public class ProxyPattern {
    public static void main(String[] args) {
        TargetInterface targetInterface =
                (TargetInterface) Proxy.newProxyInstance(ProxyPattern.class.getClassLoader(), new Class[]{TargetInterface.class}, new ProxyExample(new TargetClass()));
        targetInterface.doSomeThing();
    }
}

class ProxyExample implements InvocationHandler{

    private TargetInterface targetInterface;

    public ProxyExample(TargetInterface targetInterface) {
        this.targetInterface = targetInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("做事之前的准备");
        Object invoke = method.invoke(targetInterface, args);
        System.out.println("做事之后的清场");
        return invoke;
    }
}

interface TargetInterface{
    void doSomeThing();
}

class TargetClass implements TargetInterface{

    @Override
    public void doSomeThing() {
        System.out.println("做了一些事");
    }
}
