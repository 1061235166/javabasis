package com.k.datastructure.tree;

import javax.swing.tree.TreeNode;

/**
 * 二叉搜索树
 * created by k
 * 2018/11/28 10:38
 **/
public class BST2 {

	private TreeNode root;

	private int [] ints;

	public BST2(int[] ints) {
		this.ints = ints;
		for(int i : ints){
			root = insertToRoot(root,i);
		}
	}

	public TreeNode getNode(int data) {
		return getRoot(root,data);
	}

	public TreeNode insert(int data){
		return insertToRoot(root, data);
	}

	private TreeNode insertToRoot(TreeNode root,int data){
		TreeNode result = getRoot(root, data);
		if(result == null){
			return new TreeNode(data);
		}
		if(result.data>data){
			return insertToRoot(root.right,data);
		}else if(result.data<data){
			return insertToRoot(root.left,data);
		}
		return new TreeNode(data);
	}

	/**
	 *根据父节点和data获取指定节点
	 * @param node
	 * @param data
	 * @return
	 */
	private TreeNode getRoot(TreeNode node,int data){
		if(node!=null){
			if(node.data>data){
				return getRoot(node.right,data);
			}else if(node.data<data){
				return getRoot(node.left,data);
			}
			return node;
		}
		return null;
	}

	private class TreeNode{
		private int data;
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent;

		public TreeNode(int data) {
			this.data = data;
		}

		public TreeNode(int data, TreeNode left, TreeNode right, TreeNode parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

	public static void main(String[] args) {
		BST2 bst2  =new BST2(new int[]{3,4,5,6,7,9});
		System.out.println(bst2);
	}
}