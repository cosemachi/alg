package com.chima.alg.tree.bst;

import java.util.*;

import com.chima.alg.datastructure.singlelinkedlist.*;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private class Node {
		private final Key key;
		private Value val;
		private Node left, right;
		private int N;

		public Node(final Key key, final Value val, final int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	private Node root;

	public boolean checkBST() {
		return this.checkBST(this.root);
	}

	private boolean checkBST(final Node node) {
		if (node == null)
			return true;
		if (node.left != null && node.left.key.compareTo(node.key) > 0)
			return false;
		if (node.right != null && node.right.key.compareTo(node.key) < 0)
			return false;
		if (!this.checkBST(node.right) || !this.checkBST(node.left))
			return false;
		return true;
	}

	public void delete(final Key key) throws Exception {
		this.root = this.delete(this.root, key);
	}

	/**
	 * 
	 * @param x
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private Node delete(Node x, final Key key) throws Exception {
		if (x == null)
			return null;
		final int cmp = key.compareTo(x.key);
		if (cmp < 0)
			// The deleted node is on the left side, smaller than the compared
			// node.
			x.left = this.delete(x.left, key);
		else if (cmp > 0)
			// The deleted node is on the right side, smaller than the compared
			// node.
			x.right = this.delete(x.right, key);
		else {
			// Found node x is the node to delete...
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			final Node t = x;// keep x current information for get the right and
								// left child.
			x = this.min(t.right);// set x to be the smallest one from the right
									// child.
			x.right = this.deleteMin(t.right);//
			x.left = t.left;
		}
		x.N = this.size(x.left) + this.size(x.right) + 1;
		return x;
	}

	public Value find(final Key key) {
		return this.find(this.root, key);
	}

	private Value find(final Node node, final Key key) {
		if (node == null) {
			return null;
		}
		final int cmp = key.compareTo(node.key);
		if (cmp > 0)
			return this.find(node.right, key);
		else if (cmp < 0)
			return this.find(node.left, key);
		else
			return node.val;
	}

	public void deleteMin() throws Exception {
		if (this.root == null)
			throw new Exception("Nothing to delete, the tree is empty");
		this.root = this.deleteMin(this.root);
	}

	private Node deleteMin(final Node x) throws Exception {
		if (x.left == null)
			// there is nothing smaller than x, get the x's right child, if x
			// have no right child, then return null
			return x.right;
		x.left = this.deleteMin(x.left);
		x.N = this.size(x.left) + this.size(x.right) + 1;
		return x;
	}

	public Value get(final Key key) {
		return this.get(this.root, key);
	}

	private Value get(final Node node, final Key key) {
		if (node == null)
			return null;
		final int cmp = key.compareTo(node.key);
		if (cmp < 0)
			// key value is small than node's key, which means that exist on the
			// left child tree
			return this.get(node.left, key);
		else if (cmp > 0)
			return this.get(node.right, key);
		else
			return node.val;
	}

	public int getChildrenNumber() {
		return this.getChildrenNumber(this.root);
	}

	public int getChildrenNumber(final Node node) {
		int sum = 0;
		if (node.left == null && node.right == null) {
			return 0;
		} else if (node.left == null) {
			sum++;
			return sum += this.getChildrenNumber(node.right);
		} else if (node.right == null) {
			sum++;
			return sum += this.getChildrenNumber(node.right);
		} else {
			return sum += this.getChildrenNumber(node.right) + this.getChildrenNumber(node.left);
		}
	}

	public Value getRootValue() {
		return this.root.val;
	}

	public Key max() {
		return this.max(this.root).key;
	}

	private Node max(final Node node) {
		// Keep go to right until no left node
		if (node.right == null)
			return node;
		return this.max(node.right);
	}

	public Key min() {
		return this.min(this.root).key;
	}

	private Node min(final Node node) {
		// Keep go to left until no left node
		if (node.left == null)
			return node;
		return this.min(node.left);
	}

	public void put(final Key key, final Value val) {
		this.root = this.put(this.root, key, val);
	}

	private Node put(final Node node, final Key key, final Value val) {
		if (node == null)
			return new Node(key, val, 1);
		final int cmp = key.compareTo(node.key);
		if (cmp < 0)
			// put the node to the left side
			node.left = this.put(node.left, key, val);
		else if (cmp > 0)
			node.right = this.put(node.right, key, val);
		else
			node.val = val;
		node.N = this.size(node.left) + this.size(node.right) + 1;
		return node;
	}

	public Value getKNode(final int k) throws Exception {
		if (this.root == null)
			throw new Exception("The tree is empty!!");
		if (k > this.root.N || k <= 0) {
			throw new Exception("Invalid value");
		}
		return this.getKNode(this.root, k);
	}

	private Value getKNode(final Node node, final int k) {
		if (node.left == null) {
			// have no left child
			if (k == 1)
				return node.val;
			else
				return this.getKNode(node.right, k - 1);
		} else {
			if (k == node.left.N + 1)
				return node.val;
			else if (k < node.left.N)
				return this.getKNode(node.left, k);
			else
				return this.getKNode(node.right, k - node.left.N + 1);
		}
	}

	public int size() {
		return this.size(this.root);
	}

	public int size(final Node node) {
		if (node == null)
			return 0;
		else
			return node.N;
	}

	public int hight() {
		if (root != null)
			return Math.max(this.hight(root.left), this.hight(root.right)) + 1;
		return 0;
	}

	private int hight(final Node node) {
		if (node == null)
			return 0;
		else
			return Math.max(this.hight(node.left), this.hight(node.right)) + 1;
	}

	/**
	 * This is inorder travel tree.
	 * 
	 * <pre>
	 * inorder(node) 
	 * 		if node == null then return
	 * 		inorder(node.left) 
	 * 		visit(node) 
	 * 		inorder(node.right)
	 * </pre>
	 * 
	 * @return
	 */
	public List<Value> inOrder() {
		final List<Value> list = new ArrayList<Value>();
		this.inOrder(this.root, list);
		return list;
	}

	private void inOrder(final Node node, final List<Value> list) {
		if (node == null)
			return;
		this.inOrder(node.left, list);
		list.add(node.val);
		this.inOrder(node.right, list);
	}

	/**
	 * This is pre order travel tree.
	 * 
	 * <pre>
	 * preorder(node) 
	 * 		if node == null then return
	 * 		visit(node) 
	 * 		preorder(node.left) 
	 * 		preorder(node.right)
	 * </pre>
	 * 
	 * @return
	 */
	public List<Value> preOrder() {
		final List<Value> list = new ArrayList<Value>();
		this.preOrder(this.root, list);
		return list;
	}

	private void preOrder(final Node node, final List<Value> list) {
		if (node == null)
			return;
		list.add(node.val);
		this.preOrder(node.left, list);
		this.preOrder(node.right, list);
	}

	/**
	 * This is the post order travel.
	 * 
	 * <pre>
	 * postorder(node)
	 * 		if node == null then return
	 * 		postorder(node.left)
	 * 		postorder(node.right)
	 * 		visit(node)
	 * </pre>
	 * 
	 * @return
	 */
	public List<Value> postOrder() {
		final List<Value> list = new ArrayList<Value>();
		this.postOrder(this.root, list);
		return list;
	}

	private void postOrder(final Node node, final List<Value> list) {
		if (node == null)
			return;
		this.postOrder(node.left, list);
		this.postOrder(node.right, list);
		list.add(node.val);
	}

	/**
	 * This function is a level order travel tree. Which is also called
	 * breath-first travel.
	 * 
	 * <pre>
	 * levelorder(root) q = empty queue 
	 * q.enqueue(root)
	 * while not q.empty do 
	 * 		node := q.dequeue() 
	 * 		visit(node) 
	 * 		if node.left ≠ null
	 * 			then q.enqueue(node.left) 
	 * 		if node.right ≠ null 
	 * 			then q.enqueue(node.right)
	 * </pre>
	 * 
	 * @return the list of travel nodes in the level order sequence
	 */
	public List<Value> levelOrder() {
		if (this.root == null)
			return null;
		final FIFOSingleLinkedList<Node> queue = new FIFOSingleLinkedList<Node>();
		final List<Value> list = new ArrayList<Value>();
		queue.insert(this.root);
		while (!queue.isEmpty()) {
			final Node node = queue.delete();
			list.add(node.val);
			if (node.left != null)
				queue.insert(node.left);
			if (node.right != null)
				queue.insert(node.right);
		}
		return list;
	}
}