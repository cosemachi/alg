package homework.week6;

import java.io.*;

import org.junit.*;

public class TwoSumProblemTest {

	@Test
	public void test_two_sum_problem() {
		final TwoSumProblem testObj = new TwoSumProblem(new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week6/algo1-programming_prob-2sum.txt"));
		final int result = testObj.findTwoSumProblem(-10000, 10000);

		System.out.println(result);
	}

	@Test
	public void test_case1() {
		final TwoSumProblem testObj = new TwoSumProblem(new File("/Users/Lansing/GitResource/alg/src/test/java/homework/week6/Test1.txt"));
		final int result = testObj.findTwoSumProblem(-10000, 10000);

		System.out.println(result);
	}

	@Test
	public void test_case2() {
		final TwoSumProblem testObj = new TwoSumProblem(new File("/Users/Lansing/GitResource/alg/src/test/java/homework/week6/Test2.txt"));
		final int result = testObj.findTwoSumProblem(-10000, 10000);

		System.out.println(result);
	}

	@Test
	public void test_case3() {
		final TwoSumProblem testObj = new TwoSumProblem(new File("/Users/Lansing/GitResource/alg/src/test/java/homework/week6/Test3.txt"));
		final int result = testObj.findTwoSumProblem(-10000, 10000);

		System.out.println(result);
	}
}
