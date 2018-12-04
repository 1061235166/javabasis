package com.k.算法.leetcode_cn.easy.string;

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:
 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.

 注意事项：您可以假定该字符串只包含小写字母。
 * created by k
 * 2018/12/4 11:13
 **/
public class 字符串中的第一个唯一字符 {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("cc"));
		Integer i=1;
		System.out.println(i++);
	}

	/**
	 * 自己的解法，效率不高
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
		char[] chars = s.toCharArray();
		if(chars.length==0){
			return -1;
		}
		if(chars.length==1){
			return 1;
		}
		int st=0;
		int ed = chars.length-1;
		Map<Character,Integer>count = new HashMap<>();
		while (st<=ed){
			char a =chars[st++];
			char b =chars[ed--];
			if(count.containsKey(a)){
				Integer integer = count.get(a);
				count.put(a,integer+1);
			}else {
				count.put(a,0);
			}
			if(count.containsKey(b)){
				Integer integer = count.get(b);
				count.put(b,integer+1);
			}else {
				count.put(b,0);
			}
		}
		List<Integer>list=new ArrayList<>();
		for(Map.Entry<Character,Integer> entry : count.entrySet()){
			if(entry.getValue()==0){
				Character key = entry.getKey();
				int i = s.indexOf(key);
				list.add(i);
			}
		}
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		return list.size()==0?-1:list.get(0);
	}


	/**
	 * 网上的解法
	 * @param s
	 * @return
	 */
	public static int firstUniqChar2(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				if (map.get(s.charAt(i)) != null) {
					map.remove(s.charAt(i));
				}
			} else {
				map.put(s.charAt(i), i);
				set.add(s.charAt(i));
			}
		}
		return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
	}


	/**
	 * 网上的解法，效率高，用字符串的indexOf,非常易于理解
	 * @param s
	 * @return
	 */
	public static int firstUniqChar3(String s) {

		char[] a = s.toCharArray();

		for(int i=0; i<a.length;i++){
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){
				return i;
			}
		}
		return -1;
	}
}