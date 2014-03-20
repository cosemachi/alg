package com.chima.alg.smalltest;

/**
 * Write a function to change a int into Bit(0-1)
 * 
 * @author Lansing
 * 
 */
public class ChangeIntegerIntoBit {

	public String changeIntoBit(int i) throws Exception {
		String result = "";
		if (i < 0)
			throw new Exception("Input number need to be bigger than 0");
		do {
			result = i % 2 + result;
			i = i / 2;
		} while (i / 2 != 0);

		result = i % 2 + result;
		return result;
	}

	public int countOneInBit(int i) throws Exception {
		int result = 0;
		if (i < 0)
			throw new Exception("Input number need to be bigger than 0");
		while (i / 2 != 0) {
			if (i % 2 == 1)
				result++;
			i = i / 2;
		}
		if (i % 2 == 1)
			result++;
		return result;
	}
}
