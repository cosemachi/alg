package homework.week5;

import java.io.*;
import java.util.*;

public class GraphWithDistance {

	private final Set<String> nodes;

	private final Map<String, Map<String, Integer>> edges;

	public static final int MAX_DISTANCE = 1000000;

	public GraphWithDistance() {
		this.nodes = new HashSet<String>();
		this.edges = new HashMap<String, Map<String, Integer>>();
	}

	public GraphWithDistance(final File file) {
		this.nodes = new HashSet<String>();
		this.edges = new HashMap<String, Map<String, Integer>>();
		try {
			final BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				final String[] result = line.split("\t");
				// first is the node
				final String node = result[0];
				this.addNode(node);

				// rest is the connected nodes and distance
				final Map<String, Integer> node_edges = new HashMap<String, Integer>();

				for (int i = 1; i < result.length; i++) {
					// here is the v connects to node
					final String[] res = result[i].split(",");
					final String v = res[0];
					final String distance = res[1];
					node_edges.put(v, Integer.valueOf(distance));
				}
				this.addEdges(node, node_edges);
			}
			br.close();
		} catch (final Exception e) {
			System.out.println(e.toString());
		}

	}

	public void addEdges(final String node, final Map<String, Integer> nodeEdges) {
		this.edges.put(node, nodeEdges);
	}

	public void addNode(final String node) {
		this.nodes.add(node);
	}

	public Set<String> getConnectedNodes(final String node) {
		final Map<String, Integer> nodesList = this.edges.get(node);
		return nodesList.keySet();
	}

	public Integer getConnectedNodesDistance(final String node, final String node2) {
		final Map<String, Integer> nodesList = this.edges.get(node);
		if (nodesList.containsKey(node2)) {
			// Is connected return the distance
			return nodesList.get(node2);
		} else {
			// not connected, return the max distance
			return GraphWithDistance.MAX_DISTANCE;
		}
	}

	public void printNodes() {
		System.out.println(this.nodes.toString());
	}

	public Set<String> getNodes() {
		return this.nodes;
	}
}
