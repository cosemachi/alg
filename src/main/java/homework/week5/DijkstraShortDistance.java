package homework.week5;

import java.util.*;

public class DijkstraShortDistance {

	public int[] dijkstra(final GraphWithDistance graph, final String startNode) {

		final int[] visited = new int[graph.getNodes().size()];
		final int[] distance = new int[graph.getNodes().size()];

		Arrays.fill(visited, -1);
		Arrays.fill(distance, 1000000);

		// Set the distance to the start node to itself is 0
		distance[Integer.valueOf(startNode) - 1] = 0;

		final PriorityQueue<String> q = new PriorityQueue<String>();

		q.add(startNode);

		while (!q.isEmpty()) {
			final String node = q.remove();

			for (final String connected_node : graph.getConnectedNodes(node)) {
				final int d = graph.getConnectedNodesDistance(node, connected_node);

				final int n_d = distance[Integer.valueOf(node) - 1] + d;

				if (distance[Integer.valueOf(connected_node) - 1] > n_d) {
					distance[Integer.valueOf(connected_node) - 1] = n_d;
					visited[Integer.valueOf(connected_node) - 1] = Integer.valueOf(node);
					q.add(connected_node);
				}
			}
		}

		return distance;
	}

}
