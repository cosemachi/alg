package com.chima.alg.datastructure.singlelinkedlist;

import org.junit.*;

public class FILOSingleLinkedListTest {
	private FILOSingleLinkedList<Integer> testObj = new FILOSingleLinkedList<Integer>();

	@Before
	public void before() {
		this.testObj = new FILOSingleLinkedList<Integer>();
	}

	@Test
	public void test_create_filo_single_linked_list() {
		final Integer expectedValue = new Integer(0);
		this.testObj.popIn(expectedValue);
		Assert.assertEquals(expectedValue, this.testObj.popUp());
		Assert.assertEquals(null, this.testObj.popUp());
	}

	@Test
	public void test_create_5_nodes_and_delete_one_by_one() {
		int i = 0;
		for (; i < 5; i++) {
			this.testObj.popIn(new Integer(i));
		}
		do {
			i--;
			Assert.assertEquals(new Integer(i), this.testObj.popUp());
		} while (i > 0);
	}
}
