package homework.week1;

import java.util.*;

public class MergeSort {
	protected List<Integer> mergeSort(final List<Integer> array) {
		if (array.size() > 1) {
			final int q = array.size() / 2;

			final List<Integer> leftArray = array.subList(0, q);
			final List<Integer> rightArray = array.subList(q, array.size());

			// divide
			// conquer
			return this.merge(this.mergeSort(leftArray), this.mergeSort(rightArray));
		}
		return array;
	}

	private List<Integer> merge(final List<Integer> leftArray, final List<Integer> rightArray) {
		final int totElem = leftArray.size() + rightArray.size();
		final List<Integer> array = new ArrayList<Integer>(totElem);

		int i, li, ri;
		i = li = ri = 0;
		while (i < totElem) {
			if ((li < leftArray.size()) && (ri < rightArray.size())) {
				if (leftArray.get(li) < rightArray.get(ri)) {
					array.add(leftArray.get(li));
					i++;
					li++;
				} else {
					array.add(rightArray.get(ri));
					i++;
					ri++;
				}
			} else {
				if (li >= leftArray.size()) {
					// copy the right side to the array
					while (ri < rightArray.size()) {
						array.add(rightArray.get(ri));
						i++;
						ri++;
					}
				}
				if (ri >= rightArray.size()) {
					// copy the left side to the array
					while (li < leftArray.size()) {
						array.add(leftArray.get(li));
						li++;
						i++;
					}
				}
			}
		}
		return array;
	}
}
