package com.k.算法.leetcode_cn.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * created by wyk
 * 2018/12/5 15:02
 **/
public class 反转链表 {
	public ListNode reverseList(ListNode head) {
		ListNode node = head;
		List<ListNode> list=new ArrayList();
		while(node!=null){
			list.add(node);
			node = node.next;
		}
		ListNode tail = list.get(list.size()-1);
		ListNode nn = tail;
		for(int i=list.size()-1;i>=0;i--){
			ListNode ln = list.get(i);
			nn.next=ln;
			nn = ln;
		}
		return tail;
	}
}
