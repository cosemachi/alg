package com.chima.alg.datastructure.doublelinkedlist;

public abstract class DoubleLinkedListImpl<Value> {
	class Node {
		final Value value;
		Node prev;
		Node next;

		public Node(final Value value) {
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	protected Node head;
	protected Node tail;

	public DoubleLinkedListImpl() {
		this.head = null;
		this.tail = null;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void popIn(final Value value) {
		final Node node = new Node(value);
		if (this.isEmpty()) {
			this.tail = node;
			this.head = this.tail;
		} else {
			node.prev = this.tail;

			this.tail.next = node;
			this.tail = this.tail.next;
		}
	}

	public Value popOutFirst() {
		// Because this is fist in first out.
		// So always delete the first node when pop out.
		if (this.isEmpty()) {
			return null;
		} else {
			final Value value = this.head.value;

			if (this.head.next == null) {
				// None left
				this.head = null;
				this.tail = null;
			} else {
				// More than one left
				this.head = this.head.next;
				this.head.prev = null;
			}
			return value;
		}
	}

	public Value popOutLast() {
		// Because this is fist in last out.
		// So always delete the first node when pop out.
		if (this.isEmpty()) {
			return null;
		} else {
			final Value value = this.tail.value;

			if (this.tail == this.head) {
				// None left
				this.head = null;
				this.tail = null;
			} else {
				// More than one left
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			return value;
		}
	}

	public String println() {
		final StringBuffer sb = new StringBuffer();
		Node p = this.head;
		while (p != null) {
			sb.append("Value = " + p.value + " ");
			p = p.next;
		}
		return sb.toString();
	}

	public int size() {
		int count = 0;
		Node p = this.head;
		while (p != null) {
			count++;
			p = p.next;
		}
		return count;
	}
}
