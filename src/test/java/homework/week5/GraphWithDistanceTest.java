package homework.week5;

import java.io.*;

import org.junit.*;

public class GraphWithDistanceTest {

	@Test
	public void test_graph() {
		final GraphWithDistance graph = new GraphWithDistance(new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week5/dijkstraData.txt"));
		graph.printNodes();
		System.out.println(graph.getConnectedNodes("1").toString());
	}
}
