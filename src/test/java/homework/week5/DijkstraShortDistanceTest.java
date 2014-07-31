package homework.week5;

import java.io.*;

import org.junit.*;

public class DijkstraShortDistanceTest {
	@Test
	public void test_short_distance() {
		final DijkstraShortDistance testObj = new DijkstraShortDistance();

		final int[] distance = testObj.dijkstra(new GraphWithDistance(new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week5/dijkstraData.txt")), "1");

		for (final int i : distance) {
			System.out.println(i);
		}

		System.out.print(distance[6] + ",");
		System.out.print(distance[36] + ",");
		System.out.print(distance[58] + ",");
		System.out.print(distance[81] + ",");
		System.out.print(distance[98] + ",");
		System.out.print(distance[114] + ",");
		System.out.print(distance[132] + ",");
		System.out.print(distance[164] + ",");
		System.out.print(distance[187] + ",");
		System.out.print(distance[196]);
	}

	@Test
	public void test_case_small_1() {

		final DijkstraShortDistance testObj = new DijkstraShortDistance();

		final int[] distance = testObj.dijkstra(new GraphWithDistance(new File("/Users/Lansing/GitResource/alg/src/test/java/homework/week5/Test1.txt")), "1");

		for (final int i : distance) {
			System.out.println(i);
		}

	}

	@Test
	public void test_case_small_2() {

		final DijkstraShortDistance testObj = new DijkstraShortDistance();

		final int[] distance = testObj.dijkstra(new GraphWithDistance(new File("/Users/Lansing/GitResource/alg/src/test/java/homework/week5/Test2.txt")), "1");

		for (final int i : distance) {
			System.out.println(i);
		}
	}

	@Test
	public void test_case_small_3() {

		final DijkstraShortDistance testObj = new DijkstraShortDistance();

		final int[] distance = testObj.dijkstra(new GraphWithDistance(new File("/Users/Lansing/GitResource/alg/src/test/java/homework/week5/Test3.txt")), "1");

		for (final int i : distance) {
			System.out.println(i);
		}
	}
}
