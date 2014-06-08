package homework.week1;

import homework.week1.Problem1.Result;

import java.io.*;
import java.util.*;

import org.junit.*;

public class Problem1Test {

	Problem1 testObj = new Problem1();

	@Test
	public void testMergeFunction() {
		final LinkedList<Integer> testArray = new LinkedList<Integer>();
		testArray.add(0);
		testArray.add(5);
		testArray.add(3);
		testArray.add(4);
		testArray.add(6);
		testArray.add(8);
		final Result result = testObj.sortAndCount(testArray);
		Assert.assertEquals(2, result.result);
	}

	@Test
	public void testGetInversions() throws IOException {
		final File file = new File("/Users/Lansing/GitResource/alg/src/main/java/homework/week1/IntegerArray.txt");
		testObj = new Problem1(file);
		final Result result = testObj.sortAndCount(testObj.array);
		Assert.assertEquals("2407905288", String.valueOf(result.result));
	}
}
