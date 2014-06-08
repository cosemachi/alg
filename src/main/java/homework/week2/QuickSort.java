package homework.week2;

import java.util.*;

public class QuickSort {

	int NUM = 0;

	private int getLeftPovit(final List<Integer> a, final int l, final int r) {
		return a.get(l);
	}

	private int getLastOneAsPovit(final List<Integer> a, final int l, final int r) {
		this.swap(a, l, r - 1);
		return a.get(l);
	}

	private int getMedianPovit(final List<Integer> a, final int l, final int r) {
		final List<Integer> data = new ArrayList<Integer>();

		if (r - l <= 1) {
			return a.get(l);
		} else {
			final int left = a.get(l);
			final int right = a.get(r - 1);
			final int middle = a.get((r - 1 - l) / 2 + l);
			data.add(left);
			data.add(right);
			data.add(middle);
			Collections.sort(data);
			final int val = data.get(1);
			if (val == right) {
				this.swap(a, l, r - 1);
			} else if (val == middle) {
				this.swap(a, l, (r - l - 1) / 2 + l);
			}

			return val;
		}
	}

	/**
	 * Partition logic
	 * 
	 * @param a
	 *            array to be modified based on pivot
	 * @param start
	 *            lower bound of the array
	 * @param end
	 *            upper bound of the array
	 * @return the partition index where elements to its left are less than it
	 *         and elements to its right are more than it
	 */
	public int partition(final List<Integer> a, final int start, final int end) {
		// Get the pivot element
		final int pivot = this.getMedianPovit(a, start, end);
		int i = start + 1;

		// Break when left is > right

		for (int j = start + 1; j < end; j++) {
			if (a.get(j) <= pivot) {
				this.swap(a, j, i);
				i++;
			}
		}
		this.swap(a, start, i - 1);
		return i - 1;
	}

	/**
	 * Recursive quicksort logic
	 * 
	 * @param a
	 *            input array
	 * @param start
	 *            start index of the array
	 * @param end
	 *            end index of the array
	 */
	public void quickSort(final List<Integer> a, final int start, final int end) {
		// Handle logic to divide the array
		if (end - start <= 1)
			return;
		else {
			final int p = this.partition(a, start, end);
			this.NUM += (end - start) - 1;
			// Recursively call quick sort with left part of the divided array
			this.quickSort(a, start, p);

			// Recursively call quick sort with right part of the divided array
			this.quickSort(a, p + 1, end);
		}
	}

	private void swap(final List<Integer> array, final int x, final int y) {
		final int temp = array.get(x);
		array.set(x, array.get(y));
		array.set(y, temp);
	}
}
