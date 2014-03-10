package com.chima.alg.sort;

import java.util.*;

public class MergeSort {

	/**
	 * This method is used to merge the result
	 * 
	 * @param result
	 *            This is the merged result array
	 * @param l
	 *            This is the left side of the sorted array
	 * @param r
	 *            This is the right side of the sorted array
	 */
	private void merge(final int[] result, final int[] l, final int[] r) {
		final int totElem = l.length + r.length;

		int i, li, ri;
		i = li = ri = 0;
		while (i < totElem) {
			if ((li < l.length) && (ri < r.length)) {
				if (l[li] < r[ri]) {
					result[i] = l[li];
					i++;
					li++;
				} else {
					result[i] = r[ri];
					i++;
					ri++;
				}
			} else {
				if (li >= l.length) {
					// copy the right side to the array
					while (ri < r.length) {
						result[i] = r[ri];
						i++;
						ri++;
					}
				}
				if (ri >= r.length) {
					// copy the left side to the array
					while (li < l.length) {
						result[i] = l[li];
						li++;
						i++;
					}
				}
			}
		}
	}

	/**
	 * This is the merged result
	 * 
	 * @param array
	 */
	private void mergeSort(final int[] array) {
		if (array.length > 1) {
			final int q = array.length / 2;

			final int[] leftArray = Arrays.copyOfRange(array, 0, q);
			final int[] rightArray = Arrays.copyOfRange(array, q, array.length);

			// divide
			this.mergeSort(leftArray);
			this.mergeSort(rightArray);

			// conquer
			this.merge(array, leftArray, rightArray);
		}
	}

	public void sort(final int[] array) {
		this.mergeSort(array);
	}
}