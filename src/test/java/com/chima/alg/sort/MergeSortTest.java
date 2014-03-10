package com.chima.alg.sort;

import java.lang.reflect.*;

import org.junit.*;

public class MergeSortTest {

	/**
	 * Test for merge function. This is a test for a private function. Here we
	 * use refaction for test.
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Test
	public void test_merge() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		final Object obj = Class.forName("com.chima.alg.sort.MergeSort")
				.newInstance();
		final Class<?>[] param_types = new Class<?>[3];
		final Object[] arguments = new Object[3];
		param_types[0] = int[].class;
		param_types[1] = int[].class;
		param_types[2] = int[].class;

		final int[] a = { 2, 5, 7 };
		final int[] b = { 7, 8, 9, 10, 11 };
		final int[] result = new int[a.length + b.length];
		arguments[0] = result;
		arguments[1] = a;
		arguments[2] = b;
		final Method m = obj.getClass().getDeclaredMethod("merge", param_types);
		m.setAccessible(true);
		m.invoke(obj, arguments);
		final int[] expectedResult = { 2, 5, 7, 7, 8, 9, 10, 11 };

		Assert.assertArrayEquals(expectedResult, result);
	}

	@Test
	public void test_merge_sort() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		final Object obj = Class.forName("com.chima.alg.sort.MergeSort")
				.newInstance();
		final Class<?>[] param_types = new Class<?>[1];
		final Object[] arguments = new Object[1];
		param_types[0] = int[].class;

		final int[] a = { 1, 2, 9, 7 };

		arguments[0] = a;
		final Method m = obj.getClass().getDeclaredMethod("mergeSort",
				param_types);
		m.setAccessible(true);
		m.invoke(obj, arguments);
		final int[] expectedResult = { 1, 2, 7, 9 };

		Assert.assertArrayEquals(expectedResult, a);
	}

	@Test
	public void test_merge_sort_two_value() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		final Object obj = Class.forName("com.chima.alg.sort.MergeSort")
				.newInstance();
		final Class<?>[] param_types = new Class<?>[1];
		final Object[] arguments = new Object[1];
		param_types[0] = int[].class;

		final int[] a = { 2, 1 };

		arguments[0] = a;
		final Method m = obj.getClass().getDeclaredMethod("mergeSort",
				param_types);
		m.setAccessible(true);
		m.invoke(obj, arguments);
		final int[] expectedResult = { 1, 2 };

		Assert.assertArrayEquals(expectedResult, a);
	}

	@Test
	public void test_sort() {
		final int[] array = { 2, 5, 8, 9, 7, 3, 6 };
		final int[] expectedResult = { 2, 3, 5, 6, 7, 8, 9 };
		final MergeSort testObj = new MergeSort();
		testObj.sort(array);
		Assert.assertArrayEquals(expectedResult, array);
	}
}