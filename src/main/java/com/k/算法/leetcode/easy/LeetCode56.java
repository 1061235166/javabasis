package com.k.算法.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 * 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:

 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * created by wyk
 * 2018/11/28 11:59
 **/
public class LeetCode56 {

	public static void main(String[] args) {
		//todo 未完成
	}

	public class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {
		int minStart=0;
		int maxEnd = 0;
		List<Interval> result = new ArrayList<>();
		for(int i=0;i<intervals.size();i++){
			for(int j=0;j<intervals.size();j++){
				Interval i1 = intervals.get(i);
				Interval j1 = intervals.get(j);
				if(i1.start==j1.start && i1.end==j1.end){
					continue;
				}

			}
		}
		return null;
	}
}
