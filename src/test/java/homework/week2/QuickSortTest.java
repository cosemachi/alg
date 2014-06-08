package homework.week2;

import java.io.*;
import java.util.*;

import org.junit.*;

public class QuickSortTest {

	private List<Integer> testData;

	private QuickSort testObj;

	@Before
	public void before() throws IOException {
		this.testObj = new QuickSort();
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week2/QuickSort.txt");

		this.testData = new ArrayList<Integer>();

		final BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		while ((line = br.readLine()) != null) {
			// process the line.
			this.testData.add(Integer.valueOf(line));
		}
		br.close();
	}

	@Test
	public void testWeek2() throws IOException {
		System.out.println("Test Date Size:" + testData.size());
		this.testObj.quickSort(testData, 0, testData.size());
		for (final int a : testData) {
			System.out.println(a);
		}
		System.out.println("Recursive call:" + this.testObj.NUM);
	}

	@Test
	public void testArray() throws IOException {
		final List<Integer> data = new ArrayList<Integer>();
		data.add(3);
		data.add(8);
		data.add(2);
		data.add(5);
		data.add(1);
		data.add(4);
		data.add(7);
		data.add(6);

		this.testObj.quickSort(data, 0, data.size());
		System.out.println("Result:" + data.toString());
	}
}
