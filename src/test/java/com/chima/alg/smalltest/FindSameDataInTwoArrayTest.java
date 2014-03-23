package com.chima.alg.smalltest;

import java.util.*;

import org.junit.*;

public class FindSameDataInTwoArrayTest {
	FindSameDataInTwoArray testObj = null;

	@Before
	public void before() {
		this.testObj = new FindSameDataInTwoArray();
	}

	@Test
	public void it_should_return_common_data_when_call_the_function() {
		final int[] a = { 0, 1, 2, 4, 5 };
		final int[] b = { 2, 3, 4, 7, 9 };
		final int[] expectResult = { 2, 4 };
		final List<Integer> result = this.testObj.findSameData(a, b);
		for (int i = 0; i < expectResult.length; i++) {
			Assert.assertEquals(Integer.valueOf(expectResult[i]), result.get(i));
		}
	}
}
