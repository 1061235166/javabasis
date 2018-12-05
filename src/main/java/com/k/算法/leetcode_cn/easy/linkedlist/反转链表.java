package com.k.算法.leetcode_cn.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * created by wyk
 * 2018/12/5 15:02
 **/
public class 反转链表 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		head.next =l1;
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;

	}

	/**
	 * 自己的解法
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode node = head;

		List<ListNode>list=new ArrayList<>();
		while (node!=null){
			list.add(node);
			System.out.println(node.val);
			node = node.next;
		}
		if(list.size()==0){
			return null;
		}

		ListNode tail = list.get(list.size() - 1);
		int index = list.size() - 1;
		while (index>=0){
			ListNode listNode = list.get(index);
			if(index==0){
				listNode.next=null;
				break;
			}
			listNode.next = list.get(--index);
		}
		System.out.println(tail);
		return tail;
	}


	/**
	 * 网上的解法，递归
	 * @param head
	 * @return
	 */
	public static ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode nextNode=head.next;
		ListNode newHead=reverseList(nextNode);
		nextNode.next=head;
		head.next=null;
		return newHead;
	}
}
