package com.chima.alg.smalltest;

import com.chima.alg.smalltest.exception.*;

//[5 10 19 20] ->i (location of ) sum of i+j =k
//[1 6 16 17] -> j
//max(i, j)
//
///*
//  2 arrays:
//    - non-null
//    - sorted ascendingly
//     - arbitrary length (0...millions); not necessarily the same length
//*/
//
///*
//  kthGreatest should return the kth largest of all of the numbers
//  
//  1 => 20 
//  3 => 17
//  
//  a1: [1 2 3]
//  a2: [4 5 6]
//  k = 5
//  
//*/
//
//kthGreatest(a1, a2, 3) => 20
//kthGreatest(a1, a2, 3) => 17
//kthGreatest(a1, a2, 4) => 16
//
//kthGreatest(a1, a2, 3) => 17 //faster
//kthGreatest(a1, a2, 3) => 20
//
//(3, 17)
//(
public class GetKGreatestValue {

	public static int kthGreatest(final int[] a1, final int[] a2, int k)
			throws ArgumentException {
		if (k < 0 || k > a1.length + a2.length) {
			throw new ArgumentException("invalid k");
		}

		int i = a1.length; // i == 0 when a1.length==1 <-- kthGreatest
		int j = a2.length;

		int max = 0;

		while (k > 0 && i > 0 && j > 0) { //
			if (a1[i - 1] > a2[j - 1]) {
				max = a1[i - 1];
				i--;
				k--;
			} else if (a1[i - 1] < a2[j - 1]) {
				max = a2[j - 1];
				j--;
				k--;
			}
		}
		if (i == 0) {
			return a2[j - k];
		} else if (j == 0) {
			return a1[i - k];
		}
		return max;
	}
}
