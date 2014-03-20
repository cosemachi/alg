package com.chima.alg.smalltest;

public class RevertSingleLinkedList {
	private class Node {
		private final int value;
		private Node next;

		public Node(final int value) {
			this.value = value;
			this.next = null;
		}
	}

	private Node head;

	public void revert() {
		Node next = null, prev = null;
		if (this.head == null)
			return;
		while (true) {
			next = this.head.next;
			this.head.next = prev;
			prev = this.head;
			if (next == null)
				return;
			head = next;
		}
	}

	public void add(final int value) {
		final Node node = new Node(value);
		if (head == null) {
			this.head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	// public void revert() {
	// Node prev = null, next = null;
	// if (head == null)
	// return;
	// while (true) {
	// next = head.next;
	// head.next = prev;
	// prev = head;
	// if (next == null)
	// return;
	// head = next;
	// }
	// }

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		Node node = this.head;
		while (node != null) {
			sb.append(node.value + " ");
			node = node.next;
		}
		return sb.toString();
	}
}
