package com.k.datastructure.tree;

/**
 * 二叉搜索树
 * Created by k on 2018/5/20.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T>root;

    private int size;

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data, null, null, null);
            size++;
            return;
        }
        Node<T>current = root;
        Node<T>parent = current;
        boolean isLeft=true;
        while (current!=null){
            int i = current.data.compareTo(data);
            if (i==0){
                return;
            }
            if(i>0){
                parent = current;
                current = current.getRight();
                isLeft =false;
                continue;
            }
            if(i<0){
                parent = current;
                current = current.getLeft();
                continue;
            }
        }
        Node<T>newNode = new Node<>(data,parent,null,null);
        size++;
        if(isLeft){
            parent.setLeft(newNode);
        }else {
            parent.setRight(newNode);
        }
    }

	@Override
	public String toString() {
		return getData(root);
	}

	private String getData(Node<T>node){
    	if(node!=null){
    		return node.getData().toString()+"_"+getData(node.left)+"_"+getData(node.getRight());
		}
		return "null";
	}

	/**
     * 获取节点
     * @param data
     * @return
     */
    public Node<T>get(T data){
        return get(root,data);
    }

    private Node<T>get(Node<T>node,T data){
        Node<T> n = node;
        while (n != null) {
            if(n.data.compareTo(data)>0){
                n = n.getRight();
                continue;
            }
            if(n.data.compareTo(data)<0){
                n =n.getLeft();
                continue;
            }
            break;
        }
        return n;
    }

    private Node<T>newNode(T data,Node<T>parent,Node<T>left,Node<T>right){
        return new Node<>(data,parent,left,right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer>tree = new BinarySearchTree<>();

        tree.insert(1);
        tree.insert(-1);

        tree.insert(2);
        tree.insert(99);
        tree.insert(123);
        tree.insert(23);
        tree.insert(231123);

        Node<Integer> integerNode = tree.get(1);
        System.out.println(integerNode.getRight().getRight());

        System.out.println(tree.size);

		System.out.println(tree.toString());
    }

    /**
     * 树的节点
     * @param <T>
     */
    static class Node<T> {
        private T data;
        private Node<T>parent;
        private Node<T>left;
        private Node<T>right;

        public Node(T data, Node<T> parent, Node<T> left, Node<T> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
}