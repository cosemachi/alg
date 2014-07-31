package homework.week6;

import java.util.*;

public class BinaryMinHeap<E extends Comparable<E>> {
	List<E> h = new ArrayList<E>();

	public BinaryMinHeap() {
	}

	// building heap in O(n)
	public BinaryMinHeap(final E[] keys) {
		for (final E key : keys) {
			h.add(key);
		}
		for (int pos = h.size() / 2 - 1; pos >= 0; pos--) {
			moveDown(pos);
		}
	}

	public int size() {
		return this.h.size();
	}

	public void add(final E node) {
		h.add(node);
		moveUp(h.size() - 1);
	}

	public E getMinValue() {
		return this.h.get(0);
	}

	void moveUp(int pos) {
		while (pos > 0) {
			final int parent = (pos - 1) / 2;
			if (h.get(pos).compareTo(h.get(parent)) >= 0) {
				break;
			}
			Collections.swap(h, pos, parent);
			pos = parent;
		}
	}

	public E remove() {
		final E removedNode = h.get(0);
		final E lastNode = h.remove(h.size() - 1);
		if (!h.isEmpty()) {
			h.set(0, lastNode);
			moveDown(0);
		}
		return removedNode;
	}

	void moveDown(int pos) {
		while (pos < h.size() / 2) {
			int child = 2 * pos + 1;
			if (child < h.size() - 1 && h.get(child).compareTo(h.get(child + 1)) > 0) {
				++child;
			}
			if (h.get(pos).compareTo(h.get(child)) <= 0) {
				break;
			}
			Collections.swap(h, pos, child);
			pos = child;
		}
	}

	// Usage example
	public static void main(final String[] args) {
		final BinaryMinHeap<Integer> heap = new BinaryMinHeap<Integer>();
		heap.add(2);
		heap.add(5);
		heap.add(1);
		heap.add(4);
		heap.add(6);

		// print elements in sorted order
		while (!heap.h.isEmpty()) {
			final int x = heap.remove();
			System.out.println(x);
		}
	}
}