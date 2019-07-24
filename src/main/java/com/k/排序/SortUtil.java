package com.k.排序;

import javax.xml.ws.soap.MTOM;
import java.util.List;
import java.util.Random;

import static com.k.排序.swap.BaseSwap.random;

/**
 * 排序工具
 * Created by k on 2019/7/24.
 */
public class SortUtil {

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean less(int a, int b){
        return Integer.valueOf(a).compareTo(b) < 0;
    }

    public static void print(List<?> toPrint){
        toPrint.stream().map(Object::toString).forEach(System.out::println);
    }

    public static void swap(int [] input,int x,int y){
        int temp = input[x];
        input[x]=input[y];
        input[y]=temp;
    }

    public static int[]random(){
        int [] ins = new int[10];
        Random random = new Random(10000);
        for(int i=0;i<10;i++){
            int anInt = random.nextInt();
            ins[i]=anInt;
        }
        return ins;
    }

}
