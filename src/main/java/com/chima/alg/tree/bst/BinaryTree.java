package com.chima.alg.tree.bst;

public class BinaryTree<Value> {
	private class Node {
		Node left, right;
		Value value;

		public Node(final Value value, final Node left, final Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	private final Node root;

	public BinaryTree() {
		root = null;
	}

	public int hight() {
		return Math.max(this.hight(root.left), this.hight(root.right));
	}

	private int hight(final Node node) {
		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			return 1;
		} else {
			return this.hight((node.left != null) ? node.left : node.right) + 1;
		}
	}
}
