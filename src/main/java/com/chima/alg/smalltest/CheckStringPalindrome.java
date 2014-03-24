package com.chima.alg.smalltest;

public class CheckStringPalindrome {
	public boolean isPalindrome(final String s) {
		final int n = s.length();
		for (int i = 0; i < (n / 2) + 1; ++i) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public boolean isPalindromeWithSpace(final String s) throws Exception {
		int j = s.length() - 1;
		int i = 0;
		if (j == 0)
			throw new Exception("empty string");
		while (true) {
			while (s.charAt(i) == ' ')
				i++;
			while (s.charAt(j) == ' ')
				j--;
			if (i > j)
				return true;
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
	}
}
