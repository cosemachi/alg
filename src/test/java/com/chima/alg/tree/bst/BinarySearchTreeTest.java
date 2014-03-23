package com.chima.alg.tree.bst;

import java.util.*;

import org.junit.*;

public class BinarySearchTreeTest {

	private BinarySearchTree<String, Integer> testObj;

	@Before
	public void before() {
		this.testObj = new BinarySearchTree<String, Integer>();
	}

	private void createBST(final int[] a) {
		for (final int i : a)
			this.testObj.put(String.valueOf(i), i);
	}

	@Test
	public void test_create_6_nodes() {
		this.testObj.put("1", 1);
		this.testObj.put("2", 2);
		this.testObj.put("3", 3);
		this.testObj.put("4", 4);
		this.testObj.put("5", 5);
		this.testObj.put("6", 6);

		// *1*
		// *-2*
		// *---3*
		// *-----4*
		// *-------5*
		// *---------6*

		Assert.assertEquals(new Integer(1), this.testObj.getRootValue());
		Assert.assertEquals(6, this.testObj.size());
		Assert.assertEquals(5, this.testObj.getChildrenNumber());
		Assert.assertEquals(true, this.testObj.checkBST());
	}

	@Test
	public void test_create_first_node_as_root() {
		final String key = "1";
		final Integer val = 1;
		this.testObj.put(key, val);
		Assert.assertEquals(val, this.testObj.get(key));
	}

	@Test
	public void test_height_and_height_function() {
		this.testObj.put("1", 1);// height is 1;
		Assert.assertEquals(1, this.testObj.hight());

		this.testObj.put("3", 3);// height is 2
		Assert.assertEquals(2, this.testObj.hight());

		this.testObj.put("5", 5);// height is 3
		Assert.assertEquals(3, this.testObj.hight());

		this.testObj.put("2", 2);// height is 3
		Assert.assertEquals(3, this.testObj.hight());

		this.testObj.put("6", 6);// height is 4
		Assert.assertEquals(4, this.testObj.hight());

		this.testObj.put("4", 4);// height is 4
		Assert.assertEquals(4, this.testObj.hight());

		Assert.assertEquals("6", this.testObj.max());
	}

	@Test
	public void test_inOrder_travel_tree() {
		final int[] input = { 5, 3, 1, 2, 6, 4, 7 };
		this.createBST(input);
		final List<Integer> inOrderResult = this.testObj.inOrder();
		Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7]", inOrderResult.toString());
	}

	@Test
	public void test_preOrder_travel_tree() {
		final int[] input = { 5, 3, 1, 2, 6, 4, 7 };
		this.createBST(input);
		final List<Integer> preOrderResult = this.testObj.preOrder();
		Assert.assertEquals("[5, 3, 1, 2, 4, 6, 7]", preOrderResult.toString());
	}

	@Test
	public void test_postOrder_travel_tree() {
		final int[] input = { 5, 3, 1, 2, 6, 4, 7 };
		this.createBST(input);
		final List<Integer> postOrderResult = this.testObj.postOrder();
		Assert.assertEquals("[2, 1, 4, 3, 7, 6, 5]", postOrderResult.toString());
	}

	@Test
	public void test_levelOrder_travel_tree() {
		final int[] input = { 5, 3, 1, 2, 6, 4, 7 };
		this.createBST(input);
		final List<Integer> levelOrderResult = this.testObj.levelOrder();
		Assert.assertEquals("[5, 3, 6, 1, 4, 7, 2]", levelOrderResult.toString());
	}

	@Test
	public void test_delete_node() throws Exception {
		final int[] input = { 5, 3, 1, 2, 6, 4, 7 };
		this.createBST(input);
		this.testObj.delete("3");
		final List<Integer> inOrderResult = this.testObj.inOrder();
		Assert.assertEquals("[1, 2, 4, 5, 6, 7]", inOrderResult.toString());
	}

	@Test
	public void test_delete_min_node() throws Exception {
		final int[] input = { 5 };
		this.createBST(input);
		this.testObj.deleteMin();
		final List<Integer> inOrderResult = this.testObj.inOrder();
		Assert.assertEquals("[]", inOrderResult.toString());
	}
}