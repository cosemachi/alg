package com.chima.alg.datastructure.singlelinkedlist;

import org.junit.*;

public class FIFOSingleLinkedListTest {
	private FIFOSingleLinkedList<Integer> testObj = null;

	@Before
	public void before() {
		this.testObj = new FIFOSingleLinkedList<Integer>();
	}

	@Test
	public void test_create_a_link_list_with_one_node() {
		this.testObj.insert(new Integer(1));
		Assert.assertEquals(new Integer(1), this.testObj.getFirst());
	}

	@Test
	public void test_insert_5_value() {
		for (int i = 0; i < 5; i++)
			this.testObj.insert(new Integer(i));
		Assert.assertEquals(new Integer(0), this.testObj.getFirst());
		Assert.assertEquals(new Integer(4), this.testObj.getLast());
	}

	@Test
	public void test_insert_5_value_then_delete_one_by_one() {
		for (int i = 0; i < 5; i++)
			this.testObj.insert(new Integer(i));
		Assert.assertEquals(new Integer(0), this.testObj.getFirst());
		Assert.assertEquals(new Integer(4), this.testObj.getLast());

		for (int i = 0; i < 5; i++)
			Assert.assertEquals(new Integer(i), this.testObj.delete());
	}
}
