package com.k.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by k on 2018/5/11.
 */
public class ManProxy implements InvocationHandler {

    private Eat object;

    public ManProxy(Eat object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我就算从这里跳下去");
        System.out.println("饿死");
        System.out.println("也不吃你们一口饭");
        Object result = method.invoke(object, args);
        return result;
    }
}
