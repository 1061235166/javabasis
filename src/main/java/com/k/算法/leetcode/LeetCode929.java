package com.k.算法.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * created by wyk
 * 2018/11/26 16:26
 **/
public class LeetCode929 {
	public static int numUniqueEmails(String[] emails) {
		Set<String>set = new HashSet<>();
		for(String email : emails){
			StringBuilder stringBuilder =new StringBuilder(email);
			StringBuilder result =new StringBuilder();
			int index  = stringBuilder.indexOf("+");
			for(int i=0;i<stringBuilder.length();i++){
				String s =stringBuilder.charAt(i)+"";
				if(s.equals("@")){
					break;
				}
				if(i==index){
					break;
				}
				if(!s.equals(".")){
					result.append(s);
				}
			}
			int i = stringBuilder.indexOf("@");
			String s = stringBuilder.delete(0, i).toString();
			System.out.println(result.toString()+s);
			set.add(s);
		}
		return set.size();
	}

	public static void main(String[] args) {
		System.out.println(numUniqueEmails(new String[]{
				"test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com"}));
		System.out.println((int)'A');
		System.out.println((int)'a');
	}
}
