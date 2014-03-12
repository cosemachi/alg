package com.chima.alg.datastructure.doublelinkedlist;

public class FIFODoubleLinkedList<Value> {
	private class Node {
		private final Value value;
		private Node prev;
		private Node next;

		public Node(final Value value) {
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public FIFODoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void popIn(final Value value) {
		final Node node = new Node(value);
		if (this.head == null) {
			this.head = node;
			this.tail = node;
			this.head.next = this.tail;
			this.head.prev = this.tail;

			this.tail.next = this.head;
			this.tail.prev = this.head;
		} else {
			// The linked list is not empty. insert it to the end
			node.next = this.head;
			node.prev = this.tail;

			this.tail = node;
		}
		this.size++;
	}

	public Value popOut() {
		// Because this is fist in first out.
		// So always delete the first node when pop out.
		if (this.head == null) {
			return null;
		} else {
			final Value value = this.head.value;
			if (this.head.next == null) {
				// No node left.
				this.head = null;

				this.head.next = this.tail;
				this.head.prev = this.tail;

				this.tail.next = this.head;
				this.tail.prev = this.head;
			} else {
				this.head = this.head.next;

				this.tail.next = this.head;
			}
			return value;
		}
	}
}
