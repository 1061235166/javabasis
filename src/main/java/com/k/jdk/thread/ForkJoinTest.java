package com.k.jdk.thread;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by k on 2018/11/18.
 */
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ForkJoinPool forkJoinPool = new ForkJoinPool();


        int[]array = new int[]{13,2,42,34,21,4,657,5,67,3,234,546,7,789,2,4,345,765,47,3,4,23,42,34,3,46,7,5654,12,3};
//        int newL = array.length-10;
//        int []newA=new int[newL];
//        System.arraycopy(array,10,newA,0,newL);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(newA));

        new ArraySort(array).invoke();

        System.out.println(Arrays.toString(array));
    }
}
class ArraySort extends RecursiveAction{

    private int[] array;

    public ArraySort(int[] array) {
        this.array = array;
    }

    @Override
    protected void compute() {
        if(array.length<10){
            Arrays.sort(array);
        }else {
            int length = array.length;
            int newL = length-10;
            int []newA=new int[newL];
            System.arraycopy(array,10,newA,0,newL);
            new ArraySort(newA).fork();
        }

    }
}