package homework.week6;

import java.io.*;

import org.junit.*;

public class MedianMaintanceHeapTest {

	@Test
	public void test_case_1() {
		final MedianMaintenanceHeap<Long> testObj = new MedianMaintenanceHeap<Long>();
		long sum = 0;
		try {
			System.out.println("Start reading file into Hashtable.");
			final BufferedReader br = new BufferedReader(new FileReader("/Users/Lansing/GitResource/alg/src/test/java/homework/week6/Problem2Test2.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				final long i = Long.valueOf(line);
				testObj.addNumber(i);
				final Long median = testObj.getMedianValue();
				sum += testObj.getMedianValue();
				System.out.println("Max Heap:" + testObj.getMaxHeap() + ",Min Heap:" + testObj.getMinHeap() + ",median:" + median);
			}
			br.close();
			System.out.println("Finished reading file into Hashtable.");

			System.out.println("Sum median numbers result:" + sum % 10000);
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
	}

	@Test
	public void test_problem_2() {
		final MedianMaintenanceHeap<Long> testObj = new MedianMaintenanceHeap<Long>();
		long sum = 0;
		try {
			System.out.println("Start reading file into Hashtable.");
			final BufferedReader br = new BufferedReader(new FileReader("/Users/Lansing/Desktop/Course/Algorithm_part1 /week6/Median.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				final long i = Long.valueOf(line);
				testObj.addNumber(i);
				final Long median = testObj.getMedianValue();
				sum += median;
				// System.out.println("Max Heap:" + testObj.getMaxHeap() +
				// ",Min Heap:" + testObj.getMinHeap() + ",median:" + median);
			}
			br.close();
			System.out.println("Finished reading file into Hashtable.");

			System.out.println("Sum median numbers result:" + sum % 10000);
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
	}
}
