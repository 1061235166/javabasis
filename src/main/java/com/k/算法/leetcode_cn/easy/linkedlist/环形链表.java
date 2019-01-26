package com.k.算法.leetcode_cn.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，判断链表中是否有环。

 进阶：
 你能否不使用额外空间解决此题？
 * created by k
 * 2018/12/5 17:45
 **/
public class 环形链表 {


	public static boolean hasCycle(ListNode head) {
		int v = head.val;
		ListNode node =head;
		while (node!= null){

			node= node.next;
		}
		return false;
	}

	public static void main(String[] args) {
		List<String>list=new ArrayList<>();
		boolean contains = list.contains(null);
		System.out.println(contains);
	}
}
