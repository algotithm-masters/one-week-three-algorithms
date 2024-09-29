package programmers;

import java.util.*;

public class Programmers42861_1 {

	public int solution(int n, int[][] costs) {
		Edge[] edges = Arrays.stream(costs)
			.map(edge -> new Edge(edge[0], edge[1], edge[2]))
			.sorted(Comparator.comparingInt(e -> e.cost))
			.toArray(Edge[]::new);
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node();
		}

		int totalCost = 0;
		for (Edge edge : edges) {
			Node node1 = nodes[edge.u];
			Node node2 = nodes[edge.v];

			if (node1.isConnected(node2)) {
				continue;
			}

			node1.merge(node2);
			totalCost += edge.cost;
		}

		return totalCost;
	}

	private static class Node {
		private int depth = 1;
		private Node parent = null;

		public boolean isConnected(Node o) {
			return this.getRoot().equals(o.getRoot());
		}

		public void merge(Node o) {
			if (isConnected(o)) {
				return;
			}

			Node root1 = this.getRoot();
			Node root2 = o.getRoot();

			if (root1.depth > root2.depth) {
				root2.parent = root1;
			} else if (root1.depth < root2.depth) {
				root1.parent = root2;
			} else {
				root2.parent = root1;
				root1.depth++;
			}
		}

		private Node getRoot() {
			if (parent == null) {
				return this;
			}
			return parent.getRoot();
		}
	}

	private static class Edge {
		public final int u;
		public final int v;
		public final int cost;

		private Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
}
