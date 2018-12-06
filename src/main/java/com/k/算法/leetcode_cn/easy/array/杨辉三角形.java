package com.k.算法.leetcode_cn.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/776/
 * 输入: 5
 输出:
 [
 		 [1],
 		[1,1],
 	  [1,2,1],
 	 [1,3,3,1],
 	[1,4,6,4,1]
 ]
 * created by wyk
 * 2018/12/6 17:40
 **/
public class 杨辉三角形 {

	public static void main(String[] args) {
		System.out.println(generate(3));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>>result = new ArrayList();
		int dec = 1;
		while(dec<=numRows){
			List<Integer> list=new ArrayList(dec);
			if(dec==1){
				list.add(1);
				dec++;
				result.add(list);
				continue;
			}
			if(dec==2){
				list.add(1);
				list.add(1);
				dec++;
				result.add(list);
				continue;
			}
			//获取上一行的元素
			List<Integer> preList = result.get(dec - 1-1);
			int s = 0;
			int sum=0;
			for(int i=0;i<preList.size();i++){
				sum+=i;
				list.add(sum);
			}
			list.add(1);
			dec++;
		}
		return result;
	}
}
