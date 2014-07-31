package homework.week6;

public class MedianMaintenanceHeap<E extends Comparable<E>> {

	private final BinaryMaxHeap<E> maxHeap;

	private final BinaryMinHeap<E> minHeap;

	private int size = 0;

	public MedianMaintenanceHeap() {
		this.maxHeap = new BinaryMaxHeap<E>();
		this.minHeap = new BinaryMinHeap<E>();
	}

	public void addNumber(final E num) {
		if (this.size == 0) {
			// first insert into the max heap
			this.size++;
			this.maxHeap.add(num);
		} else {
			this.size++;
			final E maxValue = this.maxHeap.getMaxValue();

			if (num.compareTo(maxValue) > 0) {
				// put into the minHeap
				this.minHeap.add(num);
			} else {
				this.maxHeap.add(num);
			}

			// odd number
			if (Math.abs(this.maxHeap.size() - this.minHeap.size()) >= 2) {
				// one is bigger than the other one by two
				if (this.maxHeap.size() > this.minHeap.size()) {
					// get the max value from maxHeap
					final E value = this.maxHeap.remove();
					this.minHeap.add(value);
				} else {
					final E value = this.minHeap.remove();
					this.maxHeap.add(value);
				}
			}
		}
	}

	public E getMedianValue() throws Exception {
		E medianValue = null;
		switch (this.maxHeap.size() - this.minHeap.size()) {
		case 1:
			medianValue = this.maxHeap.getMaxValue();
			break;
		case 0:
			medianValue = this.maxHeap.getMaxValue();
			break;
		case -1:
			medianValue = this.minHeap.getMinValue();
			break;
		default:
			throw new Exception("Error, the Abs(maxHeap.size()-minHeap.size()) is bigger than 1");
		}
		return medianValue;
	}

	public String getMaxHeap() {
		return this.maxHeap.h.toString();
	}

	public String getMinHeap() {
		return this.minHeap.h.toString();
	}
}
