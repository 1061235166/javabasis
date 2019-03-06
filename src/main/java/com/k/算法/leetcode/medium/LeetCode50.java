package com.k.算法.leetcode.medium;

/**
 * 不使用类库计算x的n次方
 * Created by k on 2019/2/6.
 */
public class LeetCode50 {

    public static void main(String[] args) {
        System.out.println(myPow(2,6));
    }

    /**
     * 自己写的
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        //分析：x的n次方，实际是 x*x执行了n步
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }

        return x*myPow(x,n-1);
    }
}
