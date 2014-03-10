package com.chima.alg.sort;

/**
 * 
 * @author echimma
 * 
 */
public class BubbleSort {
	// Also called sinking sort
	public void bubbleSort(final int[] array) {
		boolean sorted = false;
		for (int i = 1; i < array.length; i++) {
			sorted = true;
			for (int j = 0; j < array.length - 1; j++)
				if (array[j] > array[i]) {
					final int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
					sorted = false;
				}
			if (sorted)
				break;
		}
	}
}