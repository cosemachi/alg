package homework.week1;

import java.io.*;
import java.util.*;

public class Problem1 {

	final List<Integer> array;
	final List<Integer> mergeSortedArray;

	class Result {
		final List<Integer> array;
		final long result;

		public Result(final List<Integer> array, final long result) {
			this.array = array;
			this.result = result;
		}
	}

	public Problem1() {
		this.array = new ArrayList<Integer>();
		this.mergeSortedArray = new ArrayList<Integer>();
	}

	public Problem1(final File file) throws IOException {
		this.array = new ArrayList<Integer>();
		this.mergeSortedArray = new ArrayList<Integer>();

		final BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		while ((line = br.readLine()) != null) {
			// process the line.
			this.array.add(Integer.valueOf(line));
		}
		br.close();
		this.mergeSortedArray.addAll(this.array);
	}

	public Result sortAndCount(final List<Integer> array) {
		if (array.size() > 1) {
			final int q = array.size() / 2;

			final List<Integer> leftArray = array.subList(0, q);
			final List<Integer> rightArray = array.subList(q, array.size());

			// divide
			final Result leftInversionsNum = this.sortAndCount(leftArray);
			final Result rightInversionsNum = this.sortAndCount(rightArray);
			// conquer
			return this.mergeAndCount(leftInversionsNum, rightInversionsNum);
		}
		return new Result(array, 0);
	}

	private Result mergeAndCount(final Result leftArray, final Result rightArray) {
		// TODO Auto-generated method stub
		final int totElem = leftArray.array.size() + rightArray.array.size();
		final List<Integer> array = new ArrayList<Integer>(totElem);

		long result = 0;

		int i, li, ri;
		i = li = ri = 0;
		while (i < totElem) {
			if ((li < leftArray.array.size()) && (ri < rightArray.array.size())) {
				if (leftArray.array.get(li) < rightArray.array.get(ri)) {
					array.add(leftArray.array.get(li));
					i++;
					li++;
				} else {
					array.add(rightArray.array.get(ri));
					result += (leftArray.array.size() - li);
					i++;
					ri++;
				}
			} else {
				if (li >= leftArray.array.size()) {
					// finish the left side first, don't need to do to much here
					while (ri < rightArray.array.size()) {
						array.add(rightArray.array.get(ri));
						i++;
						ri++;
					}
				}
				if (ri >= rightArray.array.size()) {
					// finish the right side first, don't need to do to much
					// here
					while (li < leftArray.array.size()) {
						array.add(leftArray.array.get(li));
						li++;
						i++;
					}
				}
			}
		}
		return new Result(array, result + leftArray.result + rightArray.result);
	}
}
