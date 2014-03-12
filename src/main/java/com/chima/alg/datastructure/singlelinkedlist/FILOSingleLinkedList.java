package com.chima.alg.datastructure.singlelinkedlist;

public class FILOSingleLinkedList<Value> {
	private class Node {
		private final Value value;
		private Node next;

		public Node(final Value value) {
			this.value = value;
			this.next = null;
		}
	}

	private Node first;
	private int size;

	public FILOSingleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public Value popUp() {
		if (this.first == null) {
			return null;
		} else {
			final Value value = this.first.value;
			this.first = this.first.next;
			return value;
		}
	}

	public void popIn(final Value value) {
		final Node node = new Node(value);
		node.next = this.first;
		this.first = node;
		this.size++;
	}
}
