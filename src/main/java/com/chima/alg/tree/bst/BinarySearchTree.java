package com.chima.alg.tree.bst;

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

	public void delete(final Key key) {
		this.root = this.delete(this.root, key);
	}

	private Node delete(Node x, final Key key) {
		if (x == null)
			return null;
		final int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = this.delete(x.left, key);
		else if (cmp > 0)
			x.right = this.delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			final Node t = x;
			x = this.min(t.right);
			x.right = this.deleteMin(t.right);
			x.left = t.left;
		}
		x.N = this.size(x.left) + this.size(x.right) + 1;
		return x;
	}

	public void deleteMin() {
		this.root = this.deleteMin(this.root);
	}

	private Node deleteMin(final Node x) {
		if (x.left == null)
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

	public int size() {
		return this.size(this.root);
	}

	public int size(final Node node) {
		if (node == null)
			return 0;
		else
			return node.N;
	}
}