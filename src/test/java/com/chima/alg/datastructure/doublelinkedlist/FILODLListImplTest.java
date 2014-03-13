package com.chima.alg.datastructure.doublelinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FILODLListImplTest {
	FIFODLListImpl<Integer> testObj = null;

	@Before
	public void before() {
		this.testObj = new FIFODLListImpl<Integer>();
	}

	@Test
	public void test_create_a_double_linked_list_with_1_node() {
		final Integer expectedResult = new Integer(0);
		this.testObj.popIn(expectedResult);
		Assert.assertEquals(expectedResult, this.testObj.popOut());
	}

	@Test
	public void test_create_a_double_linked_list_with_2_node() {
		final Integer expectedResult0 = new Integer(0);
		final Integer expectedResult1 = new Integer(1);
		this.testObj.popIn(expectedResult0);
		System.out.println(this.testObj.println());
		this.testObj.popIn(expectedResult1);
		System.out.println(this.testObj.println());
		Assert.assertEquals(expectedResult0, this.testObj.popOut());
		Assert.assertEquals(expectedResult1, this.testObj.popOut());
		Assert.assertEquals(true, this.testObj.isEmpty());
		Assert.assertEquals(0, this.testObj.size());
	}
}
