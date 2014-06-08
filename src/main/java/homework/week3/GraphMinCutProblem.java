package homework.week3;

import java.util.*;

public class GraphMinCutProblem {

	private Graph graph;
	final Random r = new Random();

	public GraphMinCutProblem(final Graph g) {
		this.graph = g;
	}

	private String getRandomizedNode() throws Exception {

		final int randomIndex = r.nextInt(graph.getNodeSize());

		return this.graph.getNode(randomIndex);
	}

	public int getMinCuts() throws Exception {
		int minCut = 0;
		while (graph.getNodeSize() > 2) {
			final String node1 = this.getRandomizedNode();
			final String node2 = this.getRandomizedNode();
			if (!node1.equals(node2))
				this.graph = this.graph.edgesContractions(node1, node2);
			else
				continue;
		}

		for (final String node : this.graph.getEdges().keySet()) {
			minCut = this.graph.getEdges().get(node).size();
		}

		return minCut;
	}
}
