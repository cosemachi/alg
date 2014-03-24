package com.chima.alg.smalltest;

/**
 * Input: Given a single linked list of Characters, Require: Remove all numeric
 * values Return: The list after remove
 * 
 * @author echimma
 * 
 */
public class RemoveNumberInSingleLinkedList {

	private class Node {
		private final char value;
		private Node next;

		public Node(final char value) {
			this.value = value;
			this.next = null;
		}
	}

	private Node root;

	public void insert(final char value) {
		final Node node = new Node(value);
		node.next = this.root;
		this.root = node;
	}

	private boolean isNumeric(final Node p) {
		if (Character.isDigit(p.value))
			// Check if this is numeric, if this is number, then remove the
			// node,
			return true;
		else
			return false;
	}

	/**
	 * Function for remove the numeric in the single linked list
	 * 
	 * @param singleList
	 * @return
	 */
	public Node removeNumeric() {
		if (this.root == null) {
			return null;
		}

		Node prevNode = null;
		Node currNode = this.root;
		while (currNode != null) {
			if (this.isNumeric(currNode)) {
				if (prevNode != null) {
					prevNode.next = currNode.next;
				}
				currNode = currNode.next;
			} else {
				if (prevNode != null) {
					prevNode.next = currNode;
				}
				prevNode = currNode;
				currNode = currNode.next;

			}
		}
		if (prevNode == null)
			return this.root = null;
		return this.root;

		// Node r = this.root;
		//
		// while (this.isNumeric(r) && r != null)
		// // first find out the first not numeric char
		// r = r.next;
		// if (r == null || r.next == null)
		// // No un-numeric char left
		// return r;
		// else {
		// Node p = r.next;
		// Node prev = r;
		// while (p.next != null) {
		// if (this.isNumeric(p)) {
		// // p is number
		// prev.next = p.next;
		// p = p.next;
		// } else {
		// prev = p;
		// p = p.next;
		// }
		//
		// }
		// return r;
		// }
	}

	@Override
	public String toString() {
		if (this.root == null)
			return "No element inside";
		return this.toString(this.root);
	}

	public String toString(final Node node) {
		final StringBuffer sb = new StringBuffer();
		Node n = node;
		while (n != null) {
			sb.append(n.value + " ");
			n = n.next;
		}
		return sb.toString();
	}
}
