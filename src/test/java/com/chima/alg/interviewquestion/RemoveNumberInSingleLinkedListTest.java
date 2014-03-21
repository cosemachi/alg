package com.chima.alg.interviewquestion;

import org.junit.Before;
import org.junit.Test;

public class RemoveNumberInSingleLinkedListTest {
	private RemoveNumberInSingleLinkedList testObj = null;

	@Before
	public void before() {
		this.testObj = new RemoveNumberInSingleLinkedList();
		this.testObj.insert('a');
		this.testObj.insert('b');
		this.testObj.insert('c');
		this.testObj.insert('0');
		this.testObj.insert('1');
		this.testObj.insert('d');
		System.out.println(this.testObj.toString());
	}

	@Test
	public void test_remove_numeric_in_single_listed_list() {

	}

}
