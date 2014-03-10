package com.chima.alg.sort;

/**
 * partition-exchange sort makes O(n log n) comparisons to sort n items. In the
 * worst case, it makes O(n2) comparisons, though this behavior is rare.
 * Quicksort is often faster in practice than other O(n log n) algorithms
 * 
 * 
 * The steps are: 1.Pick an element, called a pivot, from the list. 2.Reorder
 * the list so that all elements with values less than the pivot come before the
 * pivot, while all elements with values greater than the pivot come after it
 * (equal values can go either way). After this partitioning, the pivot is in
 * its final position. This is called the partition operation. 3.Recursively
 * apply the above steps to the sub-list of elements with smaller values and
 * separately the sub-list of elements with greater values. The base case of the
 * recursion are lists of size zero or one, which never need to be sorted.
 * 
 * @author echimma
 * 
 */
public class QuickSort {
	/**
	 * Partition logic
	 * 
	 * @param a
	 *            array to be modified based on pivot
	 * @param left
	 *            lower bound of the array
	 * @param right
	 *            upper bound of the array
	 * @return the partition index where elements to its left are less than it
	 *         and elements to its right are more than it
	 */
	public int partition(final int[] a, int left, int right) {
		// Get the pivot element
		final int pivot = a[left];

		// Break when left is > right
		while (left <= right) {
			// increment the lower bound till you find the element more than the
			// pivot
			while (a[left] < pivot)
				left++;
			// decrement the upper bound till you find the element less than the
			// pivot
			while (a[right] > pivot)
				right--;

			// swap the values which are left by lower and upper bounds
			if (left <= right) {
				this.swap(a, right, left);

				// increment left index and decrement right index
				left++;
				right--;
			}
		}
		return left;
	}

	/**
	 * Recursive quicksort logic
	 * 
	 * @param a
	 *            input array
	 * @param i
	 *            start index of the array
	 * @param j
	 *            end index of the array
	 */
	public void quickSort(final int[] a, final int i, final int j) {
		// Handle logic to divide the array
		final int idx = this.partition(a, i, j);

		// Recursively call quick sort with left part of the divided array
		if (i < idx - 1) {
			this.quickSort(a, i, idx - 1);
		}

		// Recursively call quick sort with right part of the divided array
		if (j > idx) {
			this.quickSort(a, idx, j);
		}
	}

	private void swap(final int[] array, final int x, final int y) {
		final int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}