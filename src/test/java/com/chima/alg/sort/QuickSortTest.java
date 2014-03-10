package com.chima.alg.sort;

import org.junit.*;

public class QuickSortTest {
	@Test
	public void test_quick_sort() {
		final QuickSort testObj = new QuickSort();
		final int[] array = { 1, 2, 5, 7, 9, 3, 6, 4, 8 };
		final int[] expectedResult = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		testObj.quickSort(array, 0, array.length - 1);
		Assert.assertArrayEquals(expectedResult, array);
	}

	@Test
	public void test_quick_sort_partition() {
		final QuickSort testObj = new QuickSort();
		final int[] array = { 1, 2, 5, 7, 9, 3, 6, 4, 8 };
		final int povid = testObj.partition(array, 0, array.length - 1);
		Assert.assertEquals(1, povid);
	}
}