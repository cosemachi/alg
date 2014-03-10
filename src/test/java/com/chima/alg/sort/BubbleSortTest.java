package com.chima.alg.sort;

import org.junit.*;

public class BubbleSortTest {

	@Test
	public void test_bubble_sort() {
		final BubbleSort testObj = new BubbleSort();
		final int[] array = { 1, 5, 9, 7, 3, 2, 4 };
		final int[] expectedResult = { 1, 2, 3, 4, 5, 7, 9 };

		testObj.bubbleSort(array);
		Assert.assertArrayEquals(expectedResult, array);
	}

}