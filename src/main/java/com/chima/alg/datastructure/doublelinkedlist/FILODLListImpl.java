package com.chima.alg.datastructure.doublelinkedlist;

public class FILODLListImpl<Value> extends DoubleLinkedListImpl<Value> implements DoubleLinkedList<Value> {

	public Value popOut() {
		return this.popOutLast();
	}
}
