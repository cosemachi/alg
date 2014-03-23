package com.chima.alg.smalltest;

import java.util.*;

import com.chima.alg.datastructure.singlelinkedlist.*;

public class FindDuplicatedNodeInBST<Value extends Comparable<Value>> {

	private class Node {
		private Node right;
		private Node left;
		private final Value value;

		public Node(final Value value) {
			this.value = value;
			this.right = null;
			this.left = null;
		}
	}

	private Node root;

	public FindDuplicatedNodeInBST() {
		this.root = null;
	}

	public void put(final Value val) throws Exception {
		this.root = this.put(this.root, val);
	}

	private Node put(final Node node, final Value val) {
		if (node == null)
			return new Node(val);
		final int cmp = val.compareTo(node.value);
		if (cmp < 0) {
			// if it is smaller, then put on the left side
			node.left = this.put(node.left, val);
		} else {
			// else put it on the right side
			node.right = this.put(node.right, val);
		}
		return node;
	}

	public ArrayList<Value> inorderTravel() {
		final ArrayList<Value> list = new ArrayList<Value>();
		this.inorderTravel(this.root, list);
		return list;
	}

	private void inorderTravel(final Node node, final ArrayList<Value> list) {
		if (node == null)
			return;
		this.inorderTravel(node.left, list);
		list.add(node.value);
		this.inorderTravel(node.right, list);
	}

	public FILOSingleLinkedList<Value> findDuplicatedNodesinBSTwithInorderTravel() {
		final FILOSingleLinkedList<Value> list = new FILOSingleLinkedList<Value>();
		final FILOSingleLinkedList<Value> result = new FILOSingleLinkedList<Value>();
		this.inorderTravel(this.root, list, result);
		return result;
	}

	private void inorderTravel(final Node node,
			final FILOSingleLinkedList<Value> list,
			final FILOSingleLinkedList<Value> result) {
		if (node == null)
			return;
		this.inorderTravel(node.left, list, result);
		if (!list.isEmpty() && list.getFirst().compareTo(node.value) == 0) {
			result.popIn(node.value);
		} else {
			list.popIn(node.value);
		}
		this.inorderTravel(node.right, list, result);
	}
}
