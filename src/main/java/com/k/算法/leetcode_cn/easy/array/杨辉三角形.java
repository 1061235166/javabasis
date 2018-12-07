package com.k.算法.leetcode_cn.easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/776/
 * 输入: 5
 输出:
 [
 		 [1], 1
 		[1,1], 2
 	  [1,2,1], 3
 	 [1,3,3,1], 4
 	[1,4,6,4,1] 5
 ]
 * created by wyk
 * 2018/12/6 17:40
 **/
public class 杨辉三角形 {

	public static void main(String[] args) {
		List<List<Integer>> generate = generate(100);
		generate.forEach((list)->{
			System.out.print("[");
			list.forEach((i)->{
				System.out.print(i+",");
			});
			System.out.print("]\n");
		});
	}

	/**
	 * 自己的解法
	 * @param numRows
	 * @return
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>>result = new ArrayList<>();
		for(int i=1;i<=numRows;i++){
			List<Integer>list = new ArrayList<>();
			int size = i;
			int index = 0;
			if(i==1){
				list.add(1);
				result.add(list);
				continue;
			}
			if(i==2){
				list.add(1);
				list.add(1);
				result.add(list);
				continue;
			}
			List<Integer> pre = result.get(result.size() - 1);
			for(int j=1;j<=size;j++){
				if(j==1 || j==size){
					list.add(1);
					continue;
				}
				Integer f = pre.get(index);
				Integer s = pre.get(index + 1);
				index++;
				list.add(f+s);
			}
			result.add(list);
		}
		return result;
	}
}
