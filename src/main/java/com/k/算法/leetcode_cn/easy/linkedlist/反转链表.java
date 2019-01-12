package com.k.算法.leetcode_cn.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 对dummy node的理解
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

		ListNode tail = reverseList4(head);
		while (tail!=null){
			int val = tail.val;
			System.out.println(val);
			tail = tail.next;
		}
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

	/**
	 * 非递归，网上的解法
	 * @param head
	 * @return
	 */
	public static ListNode reverseList3(ListNode head) {
		ListNode newHead = null;
		while(head!=null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}


	/**
	 * https://mp.weixin.qq.com/s?__biz=MzI0MzQyMTYzOQ==&mid=2247484880&idx=1&sn=e394ade80079b0195668e106d6a97765&chksm=e96c1d78de1b946e51cafd61e86725bb8ac0b04db536ff883d66921b627d4da61e7177adb519&scene=0&xtrack=1#rd
	 * 来自老钱的讲解，但是讲的有点复杂
	 * 后来在网上找到了3个解法，比较简单
	 * @param head
	 * @return
	 */
	public static ListNode reverseList4(ListNode head) {
		ListNode pre = null;
		ListNode now = head;
		while (now!=null){
			//获取当前节点下一个节点
			ListNode next = now.next;
			//设置当前节点的下一个节点为上一个节点，用于反转
			now.next = pre;
			//下次循环的上一个节点为当前节点
			pre = now;
			//设置下次循环的当前节点的下一个节点
			now = next;
		}
		return pre;
	}

	/**
	 * 使用递归反转链表
	 * https://www.cnblogs.com/zhengcj/p/7494089.html
	 * 递归方法1。先找到最后一个节点，然后从最后一个开始反转,然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点
	 * @param head
	 * @return
	 */
	public static ListNode reverseList5ByRecursive(ListNode head){
		if(head.next==null){
			return reverseList5ByRecursive(head);
		}
		//todo 待完成
		ListNode next = head.next;
		next.next = reverseList5ByRecursive(head);
		return next;
	}
}
