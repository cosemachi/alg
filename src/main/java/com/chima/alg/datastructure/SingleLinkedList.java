package com.chima.alg.datastructure;

public class SingleLinkedList<Value> {
	// First in first out single linked list
	private class Node {
		private final Value value;
		private Node next;

		public Node(final Value value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;
	private int size;

	public SingleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public Value delete() {
		// always delete the first node
		final Value val = this.first.value;
		this.first = this.first.next;
		return val;
	}

	public Value getFirst() {
		return this.first.value;
	}

	public Value getLast() {
		return this.last.value;
	}

	public void insert(final Value val) {
		final Node node = new Node(val);
		Node p = this.first;
		if (p == null) {
			// current link is null
			p = node;
		}
		while (p.next != null) {
			p = p.next;
		}
		p.next = node;
		this.last = node;
		this.size++;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public String println() {
		final StringBuffer sb = new StringBuffer();
		Node n = this.first;
		while (n != null) {
			System.out.println("Val = " + n.value);
			n = n.next;
		}
		return sb.toString();
	}
}
