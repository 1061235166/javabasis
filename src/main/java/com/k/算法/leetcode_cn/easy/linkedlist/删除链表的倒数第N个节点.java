package com.k.算法.leetcode_cn.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 * created by k
 * 2018/12/4 21:51
 **/
public class 删除链表的倒数第N个节点 {

	static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
      	val = x;
      }
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = head;
		List<ListNode>list = new ArrayList<>();
		while (node!=null){
			list.add(node);
			node = node.next;
		}
		int i =list.size()-n;
		int pre = i-1;
		int next = i+1;
		ListNode listNode = list.get(i);
		ListNode preNode = list.get(pre);
		ListNode nextNode = list.get(next);
		preNode.next = nextNode;
		return listNode;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		head.next=l1;
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		ListNode listNode = removeNthFromEnd(head, 2);
		System.out.println(listNode.val);
		ListNode node =head;
		while (node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}
