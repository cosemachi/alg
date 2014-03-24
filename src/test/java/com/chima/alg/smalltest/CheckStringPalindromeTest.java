package com.chima.alg.smalltest;

import junit.framework.Assert;

import org.junit.Test;

public class CheckStringPalindromeTest {
	private CheckStringPalindrome testObj = null;

	@Test
	public void test_string_palindrome() {
		this.testObj = new CheckStringPalindrome();
		Assert.assertEquals(true, this.testObj.isPalindrome("abcdcba"));
	}

	@Test
	public void test_string_palindrome_with_space() throws Exception {
		this.testObj = new CheckStringPalindrome();
		Assert.assertEquals(true, this.testObj.isPalindromeWithSpace("            a bcdc   b a"));
	}

	@Test
	public void test_string_palindrome_with_space_false() throws Exception {
		this.testObj = new CheckStringPalindrome();
		Assert.assertEquals(false, this.testObj.isPalindromeWithSpace("            a bddc   b a"));
	}
}
