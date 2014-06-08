package homework.week4;

import java.io.*;
import java.util.*;

public class Graph {
	private final Set<String> nodes;
	private final Map<String, Set<String>> edges;

	public final String RESULT_FOLDER = "/Users/Lansing/GitResource/alg/src/test/java/homework/week4/output";

	public Graph() {
		this.nodes = new HashSet<String>();
		this.edges = new HashMap<String, Set<String>>();
	}

	public Graph(final Set<String> nodes) {
		this.nodes = nodes;
		this.edges = new HashMap<String, Set<String>>();
		for (final String node : nodes) {
			this.edges.put(node, new HashSet<String>());
		}
	}

	public Graph(final File file) {
		this.nodes = new HashSet<String>();
		this.edges = new HashMap<String, Set<String>>();
		try {
			final BufferedReader br = new BufferedReader(new FileReader(file));
			// final String node = "1";
			// final List<String> node_edges = new ArrayList<String>();

			String line;
			while ((line = br.readLine()) != null) {
				final String[] result = line.split(" ");

				this.addEdge(result[0], result[1]);
				this.addNode(result[0]);
				this.addNode(result[1]);

				// process the line.
			}
			br.close();
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
	}

	public Set<String> getNodes() {
		return this.nodes;
	}

	public Graph reserveGraph() {
		final Graph reserve = new Graph(this.nodes);
		for (final String node : this.edges.keySet()) {
			for (final String v : this.edges.get(node)) {
				reserve.getEdges(v).add(node);
			}
		}
		return reserve;
	}

	public Set<String> getEdges(final String node) {
		return this.edges.get(node);
	}

	public void addEdge(final String node1, final String node2) {
		Set<String> node1_edges = this.edges.get(node1);
		if (node1_edges == null) {
			node1_edges = new HashSet<String>();
		}
		node1_edges.add(node2);
		this.edges.put(node1, node1_edges);
	}

	public void addEdges(final String node, final Set<String> nodeEdges) {
		this.edges.put(node, nodeEdges);
	}

	public void addNode(final String node) {
		this.nodes.add(node);
	}

	public void printNodes() {
		System.out.println("This graph has " + this.nodes.size() + " nodes");
		for (final String node : this.nodes) {
			System.out.print(node + " ");
		}
	}

	public void printEdges() {
		for (final String key : this.edges.keySet()) {
			System.out.println(key + ": " + this.edges.get(key).toString());
		}
	}

}
