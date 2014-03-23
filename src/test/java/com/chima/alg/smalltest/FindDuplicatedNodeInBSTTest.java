package com.chima.alg.smalltest;

import java.util.*;

import org.junit.*;

import com.chima.alg.datastructure.singlelinkedlist.*;

public class FindDuplicatedNodeInBSTTest {
	private FindDuplicatedNodeInBST<Integer> testObj = null;

	@Before
	public void before() {
		this.testObj = new FindDuplicatedNodeInBST<Integer>();
	}

	private void insertNode() throws Exception {
		this.testObj.put(2);
		this.testObj.put(1);
		this.testObj.put(5);
		this.testObj.put(4);
		this.testObj.put(4);
		this.testObj.put(4);
		this.testObj.put(6);
		this.testObj.put(2);
		this.testObj.put(4);
	}

	@Test
	public void test_insert_9_numbers_in_BST_and_do_inorder_travel()
			throws Exception {
		this.insertNode();
		final ArrayList<Integer> nodeList = this.testObj.inorderTravel();
		System.out.println(nodeList.toString());
		Assert.assertEquals("[1, 2, 2, 4, 4, 4, 4, 5, 6]", nodeList.toString());
	}

	@Test
	public void test_find_duplicate_node_in_the_tree() throws Exception {
		this.insertNode();
		final FILOSingleLinkedList<Integer> duplicatedNode = testObj
				.findDuplicatedNodesinBSTwithInorderTravel();
		Assert.assertEquals("4 4 4 2 ", duplicatedNode.toString());
	}
}
