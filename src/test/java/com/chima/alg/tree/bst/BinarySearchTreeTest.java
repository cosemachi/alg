package com.chima.alg.tree.bst;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

	private final BinarySearchTree<String, Integer> testObj = new BinarySearchTree<String, Integer>();

	@Test
	public void test_create_first_node_as_root() {
		final String key = "1";
		final Integer val = 1;
		this.testObj.put(key, val);
		Assert.assertEquals(val, this.testObj.get(key));
	}
}