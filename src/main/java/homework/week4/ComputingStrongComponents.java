package homework.week4;

import java.io.*;
import java.util.*;

public class ComputingStrongComponents {
	private final Graph graph;
	private final Map<String, Boolean> mark;
	private final Stack<String> finishingTime;
	private final Map<String, String> leader;
	private static String S = null;

	public ComputingStrongComponents(final String file) {
		this.graph = new Graph(new File(file));
		this.mark = new HashMap<String, Boolean>();

		this.cleanMark();

		this.finishingTime = new Stack<String>();
		this.leader = new HashMap<String, String>();
	}

	private void cleanMark() {
		for (final String node : this.graph.getNodes()) {
			this.mark.put(node, false);
		}
	}

	public void SCC() {
		// First calculate the finished time of each nodes
		for (int i = this.graph.getNodes().size(); i >= 1; i--) {
			final String node = String.valueOf(i);
			if (!mark.get(node)) {
				// if i is not visited
				this.DFS_T(node);
			}
		}

		this.cleanMark();
		final Graph reserveGraph = this.graph.reserveGraph();

		// Second DFS search final with the decreasing final order of the
		// finished time
		while (!this.finishingTime.isEmpty()) {
			final String node = this.finishingTime.pop();
			// System.out.println("node:" + node);
			if (!mark.get(node)) {
				// System.out.println("Visit node:" + node);
				ComputingStrongComponents.S = node;
				this.DFS_Loop_Leader(node, reserveGraph);
			}
		}
	}

	public void DFS_Loop_Leader(final String i, final Graph graph) {
		// mark the this node is visited
		this.mark.put(i, true);
		this.leader.put(i, ComputingStrongComponents.S);

		if (graph.getEdges(i) != null) {
			for (final String v : graph.getEdges(i)) {
				if (!this.mark.get(v)) {
					// if v is not visited
					this.DFS_Loop_Leader(v, graph);
				}
			}
		}
	}

	public void DFS_T(final String i) {
		// mark the this node is visited
		this.mark.put(i, true);

		if (this.graph.getEdges(i) != null) {
			for (final String v : this.graph.getEdges(i)) {
				if (!this.mark.get(v)) {
					// if v is not visited
					this.DFS_T(v);
				}
			}
			this.finishingTime.push(i);
		}
	}

	public void printLeader() {
		for (final String key : this.leader.keySet()) {
			System.out.println("leader(" + key + "):" + this.leader.get(key));
		}
	}

	public void printF() {
		System.out.println(this.finishingTime.toString());
	}

	public void getTop5CSSGroupNumber() {
		final Map<String, Set<String>> sccGroup = new HashMap<String, Set<String>>();
		for (final String key : this.leader.keySet()) {
			final String groupLeader = this.leader.get(key);
			Set<String> member = sccGroup.get(groupLeader);
			if (sccGroup.get(groupLeader) == null) {
				member = new HashSet<String>();
			}
			member.add(key);
			sccGroup.put(groupLeader, member);
		}

		final List<Integer> resultSize = new ArrayList<Integer>();
		for (final String key : sccGroup.keySet()) {
			resultSize.add(sccGroup.get(key).size());
		}

		Collections.sort(resultSize);
		Collections.reverse(resultSize);
		for (int i = 0; i < 5; i++) {
			if (i < resultSize.size())
				System.out.print(resultSize.get(i) + ",");
			else
				System.out.print(0 + ",");
		}
	}
}
