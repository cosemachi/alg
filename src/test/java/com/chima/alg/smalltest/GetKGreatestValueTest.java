package com.chima.alg.smalltest;

import static org.junit.Assert.*;

import org.junit.*;

import com.chima.alg.smalltest.exception.*;

public class GetKGreatestValueTest {
	final int[] a1 = { 1, 2, 4, 7 };
	final int[] a2 = { 9, 10, 11, 12 };

	@Test
	public void test_biggest_valuetest_biggest_valuetest_biggest_value() {
		try {
			Assert.assertEquals(12, GetKGreatestValue.kthGreatest(a1, a2, 1));
		} catch (final Exception e) {
			fail("Should be no exception");
		}
	}

	@Test(expected = ArgumentException.class)
	public void test_not_valid_exception() throws ArgumentException {
		GetKGreatestValue.kthGreatest(a1, a2, -1);
	}

	@Test
	public void test_second_biggest_value() {
		try {
			Assert.assertEquals(11, GetKGreatestValue.kthGreatest(a1, a2, 2));
		} catch (final Exception e) {
			fail("Should be no exception");
		}
	}

	@Test
	public void test_last_biggest_value() {
		try {
			Assert.assertEquals(1, GetKGreatestValue.kthGreatest(a1, a2, 8));
		} catch (final Exception e) {
			fail("Should be no exception");
		}
	}
}
