package com.chima.alg.smalltest;

import org.junit.*;

public class RevertSingleLinkedListTest {
	private RevertSingleLinkedList testObj = null;

	@Before
	public void before() {
		this.testObj = new RevertSingleLinkedList();
	}

	@Test
	public void test_add_values_into_single_linked_list() {
		for (int i = 0; i < 10; i++)
			this.testObj.add(i);
		System.out.println(this.testObj.toString());
	}

	@Test
	public void test_revert_values_into_single_linked_list() {
		for (int i = 0; i < 10; i++)
			this.testObj.add(i);
		this.testObj.revert();
		System.out.println(this.testObj.toString());
	}
}
