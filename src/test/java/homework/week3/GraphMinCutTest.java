package homework.week3;

import java.io.*;
import java.util.*;

import org.junit.*;

public class GraphMinCutTest {

	protected GraphMinCutProblem testObj;
	private final Graph testGraph = new Graph();

	@Before
	public void before() throws NumberFormatException, IOException {
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week3/10 - 5 - Depth-First Search (DFS)- The Basics (7 min).txt");

		final BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		while ((line = br.readLine()) != null) {
			final List<String> lineData = new ArrayList<String>();
			final String[] result = line.split("\t");
			for (int i = 1; i < result.length; i++) {
				lineData.add(result[i]);
			}
			// process the line.
			this.testGraph.addNode(result[0]);
			this.testGraph.addEdges(result[0], lineData);
		}
		br.close();

		this.testObj = new GraphMinCutProblem(this.testGraph);
	}

	@Test
	public void test_min_cut_problem() throws Exception {
		int num = this.testObj.getMinCuts();
		System.out.println(num);
		for (int i = 0; i < 2000; i++) {
			this.testObj = new GraphMinCutProblem(this.testGraph);
			final int temp = this.testObj.getMinCuts();
			System.out.println(i + ":" + temp);
			if (temp < num)
				num = temp;
			System.out.println("Min Cut:" + num);
		}
	}

	@Test
	public void test_small_graph() throws Exception {
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week3/test.txt");
		Graph smallGraph = new Graph(file);
		this.testObj = new GraphMinCutProblem(smallGraph);

		smallGraph = smallGraph.edgesContractions("1", "2");

		System.out.println("Merge 1 and 2");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("3", "4");

		System.out.println("Merge 3 and 4");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("1,2", "3,4");

		System.out.println("Merge 1,2 and 3,4");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("5", "6");

		System.out.println("Merge 5 and 6");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("7", "8");

		System.out.println("Merge 7 and 8");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("5,6", "7,8");

		System.out.println("Merge 5,6 and 7,8");
		smallGraph.printEdges();

		// System.out.println("Mim Cuts:" + this.testObj.getMinCuts());

	}

	@Test
	public void test1_small_graph_min_cuts() throws Exception {
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week3/test.txt");
		final Graph smallGraph = new Graph(file);
		this.testObj = new GraphMinCutProblem(smallGraph);
		int num = testObj.getMinCuts();

		for (int i = 0; i < 2000; i++) {
			this.testObj = new GraphMinCutProblem(smallGraph);
			final int temp = this.testObj.getMinCuts();
			System.out.println(i + ":" + temp);
			if (temp < num)
				num = temp;
		}
		System.out.println("min cut:" + num);
	}

	@Test
	public void test3_small_graph_min_cuts() throws Exception {
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week3/test3.txt");
		final Graph smallGraph = new Graph(file);
		this.testObj = new GraphMinCutProblem(smallGraph);
		int num = testObj.getMinCuts();

		for (int i = 0; i < 200000; i++) {
			this.testObj = new GraphMinCutProblem(smallGraph);
			final int temp = this.testObj.getMinCuts();
			System.out.println(i + ":" + temp);
			if (temp < num)
				num = temp;
		}
		System.out.println("min cut:" + num);
	}

	@Test
	public void test3_small_graph_min_cuts_steps() throws Exception {
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week3/test3.txt");
		Graph smallGraph = new Graph(file);
		smallGraph = smallGraph.edgesContractions("1", "2");
		smallGraph = smallGraph.edgesContractions("4", "5");
		smallGraph = smallGraph.edgesContractions("1,2", "4,5");
		smallGraph = smallGraph.edgesContractions("1,2,4,5", "8");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8", "10");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10", "12");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12", "13");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13", "14");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14", "15");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15", "18");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18", "19");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19", "20");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20", "21");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21", "23");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23", "24");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24", "25");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25", "27");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27", "29");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27,29", "31");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27,29,31", "36");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27,29,31,36", "39");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27,29,31,36,39", "9");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27,29,31,36,39,9", "26");
		smallGraph = smallGraph.edgesContractions("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27,29,31,36,39,9,26", "37");

		smallGraph = smallGraph.edgesContractions("11", "17");
		smallGraph = smallGraph.edgesContractions("11,17", "30");
		smallGraph = smallGraph.edgesContractions("11,17,30", "3");
		smallGraph = smallGraph.edgesContractions("11,17,30,3", "6");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6", "7");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7", "16");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16", "22");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16,22", "28");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16,22,28", "32");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16,22,28,32", "33");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16,22,28,32,33", "34");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16,22,28,32,33,34", "35");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16,22,28,32,33,34,35", "38");
		smallGraph = smallGraph.edgesContractions("11,17,30,3,6,7,16,22,28,32,33,34,35,38", "40");

		smallGraph.printEdges();
		System.out.println(smallGraph.getEdges().get("1,2,4,5,8,10,12,13,14,15,18,19,20,21,23,24,25,27,29,31,36,39,9,26,37").size());
	}

	@Test
	public void test2_small_graph_min_cuts() throws Exception {
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week3/test2.txt");
		final Graph smallGraph = new Graph(file);
		this.testObj = new GraphMinCutProblem(smallGraph);
		int num = testObj.getMinCuts();

		for (int i = 0; i < 2000; i++) {
			this.testObj = new GraphMinCutProblem(smallGraph);
			final int temp = this.testObj.getMinCuts();
			System.out.println(i + ":" + temp);
			if (temp < num)
				num = temp;
		}
		System.out.println("min cut:" + num);
	}

	@Test
	public void test_2() {
		final File file = new File("/Users/Lansing/Desktop/Course/Algorithm_part1 /week3/test2.txt");
		Graph smallGraph = new Graph(file);
		this.testObj = new GraphMinCutProblem(smallGraph);

		smallGraph = smallGraph.edgesContractions("1", "2");

		System.out.println("Merge 1 and 2");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("3", "4");

		System.out.println("Merge 3 and 4");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("1,2", "3,4");

		System.out.println("Merge 1,2 and 3,4");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("5", "6");

		System.out.println("Merge 5 and 6");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("7", "8");

		System.out.println("Merge 7 and 8");
		smallGraph.printEdges();

		smallGraph = smallGraph.edgesContractions("5,6", "7,8");

		System.out.println("Merge 5,6 and 7,8");
		smallGraph.printEdges();

		System.out.println(smallGraph.getEdges().get("1,2,3,4").size());
	}
}
