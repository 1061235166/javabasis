package com.k.designPattern;


/**
 * 重新复习一下双重检查锁
 * Created by k on 2020/5/5.
 */
public class SingleTonTest {

    private volatile static SingleTonTest instance;

    private SingleTonTest(){

    }

    public static SingleTonTest getInstance(){
        if(instance==null){
            synchronized (SingleTonTest.class){
                if(instance == null){
                    instance = new SingleTonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for(int i=0;i<50;i++){
            new Thread(){
                @Override
                public void run() {
                    System.out.println(SingleTonTest.getInstance());
                }
            }.start();

        }
    }

}
