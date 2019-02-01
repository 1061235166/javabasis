package com.k.算法.leetcode.medium;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 反转字符串
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Created by k on 2018/11/28.
 */
public class LeetCode151 {

    public static void main(String[] args) {
        reverse(null);
    }

    public static String reverse(String string){
        List<String>list= new ArrayList();
        char[] chars = string.toCharArray();
        List<Integer>integers = new ArrayList<>();
        //记录所有有空格的下标
        for(int i=0;i<string.length();i++){
            char c = string.charAt(i);
            if(Character.isSpaceChar(c)){
                integers.add(i);
            }
        }
        List<Integer>integers2 = new ArrayList<>();
        for(int i=0;i<integers.size();i++){
            if((integers.get(i)==integers.get(i+1)) && i<integers.size()-1){
                integers2.add(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        for(Integer i : integers){
            stringBuilder.deleteCharAt(i);
        }
        return string;
    }
}
