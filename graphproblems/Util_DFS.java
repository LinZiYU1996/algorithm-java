package graphproblems;

public class Util_DFS {
	int[] visited;
	public Util_DFS(int nums) {
			visited = new int[nums];
	}
	public void dfs(AdjGraph adjGraph,int vex) {
		int w;
		EdgeNode node;
		visited[vex] = 1;
		node = adjGraph.vexNodes[Util_Graph.getPosition(adjGraph.vexNodes,vex)].first_node;
		while (node != null) {
			w = node.adj_num;
			if (visited[w] == 0) {
				dfs(adjGraph,adjGraph.vexNodes[w].data);
			}
			node = node.next_node;
		}
	}
}
