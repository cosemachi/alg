package com.chima.alg.smalltest;

import java.util.*;

/**
 * Give two array: a1=[0,1,2,4,5], a2=[2,3,4,7,9], find out the common data. For
 * example, here the output should be = [2,4]
 * 
 * @author Lansing
 * 
 */
public class FindSameDataInTwoArray {
	public List<Integer> findSameData(final int[] a, final int[] b) {
		final List<Integer> result = new ArrayList<Integer>();

		final HashSet<Integer> map = new HashSet<Integer>();
		for (final int i : a)
			map.add(i);
		for (final int i : b) {
			if (map.contains(i))
				// found duplicate!
				result.add(i);
		}
		return result;
	}
}
