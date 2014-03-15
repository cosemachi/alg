package com.chima.alg.tree.bst;

import org.junit.*;

public class BinarySearchTreeTest {

	private BinarySearchTree<String, Integer> testObj;

	@Before
	public void before() {
		this.testObj = new BinarySearchTree<String, Integer>();
	}

	@Test
	public void test_create_6_nodes() {
		this.testObj.put("1", 1);
		this.testObj.put("2", 2);
		this.testObj.put("3", 3);
		this.testObj.put("4", 4);
		this.testObj.put("5", 5);
		this.testObj.put("6", 6);
		Assert.assertEquals(new Integer(1), this.testObj.getRootValue());
		Assert.assertEquals(6, this.testObj.size());
		Assert.assertEquals(5, this.testObj.getChildrenNumber());
		Assert.assertEquals(true, this.testObj.checkBST());
		System.out.println(this.testObj.size());
	}

	@Test
	public void test_create_first_node_as_root() {
		final String key = "1";
		final Integer val = 1;
		this.testObj.put(key, val);
		Assert.assertEquals(val, this.testObj.get(key));
	}

	@Test
	public void test_max_function() {
		this.testObj.put("1", 1);
		System.out.println("height:" + this.testObj.hight());
		this.testObj.put("3", 3);
		System.out.println("height:" + this.testObj.hight());
		this.testObj.put("5", 5);
		System.out.println("height:" + this.testObj.hight());
		this.testObj.put("2", 2);
		System.out.println("height:" + this.testObj.hight());
		this.testObj.put("6", 6);
		System.out.println("height:" + this.testObj.hight());
		this.testObj.put("4", 4);
		System.out.println("height:" + this.testObj.hight());

		Assert.assertEquals("6", this.testObj.max());
		System.out.println("height:" + this.testObj.hight());
	}
}