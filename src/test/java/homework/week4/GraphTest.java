package homework.week4;

import java.io.*;

import org.junit.*;

public class GraphTest {

	@Test
	public void test_graph_1() {
		final Graph test = new Graph(new File("/Users/Lansing/GitResource/alg/src/test/java/homework/week4/Test1.txt"));
		test.printEdges();
	}

	@Test
	public void test_graph_2() {
		final Graph test = new Graph(new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week4/SCC.txt"));
		test.printEdges();
	}
}
