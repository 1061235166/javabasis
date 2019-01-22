package com.k.算法;

/**
 * 你能在多大程度上将一叠卡片悬置在桌子上
 * https://mp.weixin.qq.com/s?__biz=MzI5MzYzMDAwNw==&mid=2247484385&idx=1&sn=796712e496a6fe2d07d8b4d39b712dca&chksm=ec6e7ab9db19f3af809739c0d0560027a2f3048c7e5da1ea8e955022ad4683263c57239b6d65&scene=0&xtrack=1#rd
 * Created by k on 2018/11/30.
 */
public class NumberOfCards {

    public static void main(String[] args) {
//        int number_of_cards(float length)
//        测试用例：
//        1.00 => 3
//        3.71 => 61
//        0.04 => 1
//        5.19 => 273
        System.out.println(number_of_cards(1.00f));
        System.out.println(number_of_cards(3.71f));
        System.out.println(number_of_cards(0.04f));
        System.out.println(number_of_cards(5.19f));
    }

    public static int number_of_cards(float length){
        float sum = 0;
        int j=2;
        while (sum<=length){
            if(sum==length){
                return j;
            }
            sum = sum+1/j;
            j++;
        }
        return j;
    }
}