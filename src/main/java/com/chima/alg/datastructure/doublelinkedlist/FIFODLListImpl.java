package com.chima.alg.datastructure.doublelinkedlist;

public class FIFODLListImpl<Value> extends DoubleLinkedListImpl<Value> implements DoubleLinkedList<Value> {
	public Value popOut() {
		return this.popOutFirst();
	}
}
