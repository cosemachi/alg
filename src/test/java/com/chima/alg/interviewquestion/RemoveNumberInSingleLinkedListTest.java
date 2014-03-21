package com.chima.alg.interviewquestion;

import org.junit.Before;
import org.junit.Test;

public class RemoveNumberInSingleLinkedListTest {
	private RemoveNumberInSingleLinkedList testObj = null;

	@Before
	public void before() {
		this.testObj = new RemoveNumberInSingleLinkedList();
	}

	@Test
	public void test_remove_all_numeric_in_single_listed_list() {
		this.testObj.insert('a');
		this.testObj.insert('b');
		this.testObj.insert('c');
		this.testObj.insert('0');
		this.testObj.insert('1');
		this.testObj.insert('d');
		System.out.println("Before remove: " + this.testObj.toString());
		this.testObj.removeNumeric();
		System.out.println("After remove: " + this.testObj.toString());
	}

	@Test
	public void test_remove_numeric_at_the_beginning_in_single_listed_list() {
		this.testObj.insert('1');
		this.testObj.insert('2');
		this.testObj.insert('3');
		this.testObj.insert('c');
		this.testObj.insert('d');
		this.testObj.insert('e');
		System.out.println("Before remove: " + this.testObj.toString());
		this.testObj.removeNumeric();
		System.out.println(this.testObj.toString());
	}

	@Test
	public void test_remove_numeric_in_single_listed_list() {
		this.testObj.insert('1');
		this.testObj.insert('2');
		this.testObj.insert('3');
		this.testObj.insert('4');
		this.testObj.insert('5');
		this.testObj.insert('6');
		System.out.println("Before remove: " + this.testObj.toString());
		this.testObj.removeNumeric();
		System.out.println(this.testObj.toString());
	}

	@Test
	public void test_remove_numeric_in_the_middle_in_single_listed_list() {
		this.testObj.insert('a');
		this.testObj.insert('b');
		this.testObj.insert('c');
		this.testObj.insert('4');
		this.testObj.insert('5');
		this.testObj.insert('d');
		System.out.println("Before remove: " + this.testObj.toString());
		this.testObj.removeNumeric();
		System.out.println(this.testObj.toString());
	}

}
