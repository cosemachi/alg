package homework.week3;

import java.io.*;
import java.util.*;

public class Graph {
	private final Set<String> nodes;
	private final Map<String, List<String>> edges;

	public Graph() {
		this.nodes = new HashSet<String>();
		this.edges = new HashMap<String, List<String>>();
	}

	public Graph(final File file) {
		this.nodes = new HashSet<String>();
		this.edges = new HashMap<String, List<String>>();
		try {
			final BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				final List<String> lineData = new ArrayList<String>();
				final String[] result = line.split("\t");
				for (int i = 1; i < result.length; i++) {
					lineData.add(result[i]);
				}
				// process the line.
				this.addNode(result[0]);
				this.addEdges(result[0], lineData);
			}
			br.close();
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
	}

	public void addEdges(final String node, final List<String> nodeEdges) {
		this.edges.put(node, nodeEdges);
	}

	public void addNode(final String node) {
		this.nodes.add(node);
	}

	/**
	 * This method merge two nodes into one and also merge the edges
	 * 
	 * @param node1
	 * @param node2
	 * 
	 * @return return the new Graph after merge two edges
	 */
	public Graph edgesContractions(final String node1, final String node2) {
		final Graph graph = new Graph();
		final String mergedNode = node1 + "," + node2;
		// Put the rest nodes' into this and updated node1 and node2 into
		// "node1,node2"
		for (final String key : this.edges.keySet()) {
			if (!key.equals(node1) && !key.equals(node2)) {
				// update other node's edges
				final List<String> updateEdges = new ArrayList<String>(this.edges.get(key));
				for (int i = 0; i < updateEdges.size(); i++) {
					// We use here to update node1 and node2 into "node1, node2"
					if (updateEdges.get(i).equals(node1) || updateEdges.get(i).equals(node2)) {
						updateEdges.set(i, mergedNode);
					}
				}
				graph.addEdges(key, updateEdges);
				graph.addNode(key);
			} else {
				// need to update node 1 or node 2's edges

				final List<String> mergeNodeEdge = new ArrayList<String>();
				for (final String node1_edges : this.edges.get(node1)) {
					if (!node1_edges.equals(node2))
						// if node1 is connected to node2, ignore it
						mergeNodeEdge.add(node1_edges);
				}
				for (final String node2_edges : this.edges.get(node2)) {
					if (!node2_edges.equals(node1))
						// if node2 is connected to node1, ignore it
						mergeNodeEdge.add(node2_edges);
				}
				graph.addEdges(mergedNode, mergeNodeEdge);
				graph.addNode(mergedNode);
			}
		}

		return graph;
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

	public int getNodeSize() {
		return this.nodes.size();
	}

	public String getNode(final int randomIndex) throws Exception {
		if (randomIndex < this.nodes.size())
			return (String) this.nodes.toArray()[randomIndex];
		else
			throw new Exception("Random error!");
	}

	public Map<String, List<String>> getEdges() {
		return this.edges;
	}

}
