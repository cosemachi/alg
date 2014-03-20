package com.chima.alg.smalltest;

import org.junit.*;

public class ChangeIntegerIntoBitTest {
	private ChangeIntegerIntoBit testObj = null;

	@Before
	public void before() {
		this.testObj = new ChangeIntegerIntoBit();
	}

	@Test
	public void test_change_integer_into_bit() throws Exception {
		final int testValue = 10;
		final String result = this.testObj.changeIntoBit(testValue);
		Assert.assertEquals(Integer.toBinaryString(testValue), result);
	}

	@Test
	public void it_should_get_two_one_when_count_bit_for_10() throws Exception {
		final int testValue = 10;
		final int result = this.testObj.countOneInBit(testValue);
		Assert.assertEquals(Integer.bitCount(testValue), result);
	}
}
