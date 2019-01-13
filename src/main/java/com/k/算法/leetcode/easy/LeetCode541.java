package com.k.算法.leetcode.easy;

/**
 * 反转字符串2
 * https://leetcode-cn.com/problems/reverse-string-ii/submissions/
 * Created by k on 2019/1/12.
 * todo
 */
public class LeetCode541 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
    }

    public static String reverseStr(String s, int k) {
        if(s.length()<k){
            return s;
        }
        char[] cs = s.toCharArray();
        int st = 0;
            while (st<=s.length()){

                revers(cs,st,k);
                st =st+k;
            }
        return new String(cs);
    }

    private static void revers(char[] cs,int start,int k){
        int s = start;
        int e = start+k-1;
        while (s<=e){
            char a =cs[s];
            char b =cs[e];
            cs[s]=b;
            cs[e]=a;
            s++;e++;
        }
    }

}
