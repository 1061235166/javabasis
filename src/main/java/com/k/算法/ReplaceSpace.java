package com.k.算法;

/**
 * 替换空格
 * http://t.cn/E2RV7Wv
 * created by wyk
 * 2018/11/22 16:41
 **/
public class ReplaceSpace {

	public static String replaceSpace(StringBuffer str){
		String replace = "%20";
		System.out.println(str.length());
		for(int i=0;i<=str.length()-1;i++){
			char c = str.charAt(i);
			if(Character.isSpaceChar(c)){
				str.replace(i,i+1,replace);
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("helloworld ")));
	}
}
