package graphproblems;


/**
 * 深度遍历
 * @author linziyu
 *
 */
public class DFS {
	int[] visited;
	public DFS(int nums) {
			visited = new int[nums];
	}
	public void dfs(AdjGraph adjGraph,int vex) {
		int w;
		EdgeNode node;
		visited[vex] = 1;
		System.out.print(vex+" ");
		node = adjGraph.vexNodes[Util_Graph.getPosition(adjGraph.vexNodes,vex)].first_node;
		while (node != null) {
			w = node.adj_num;
			if (visited[w] == 0) {
				dfs(adjGraph,adjGraph.vexNodes[w].data);
			}
			node = node.next_node;
		}
	}
	

	public static void main(String[] args) {
		AdjGraph adjGraph = new AdjGraph();
		int[][] datas = {
				{0,1},
				{0,4},
				{1,2},
				{1,3},
				{1,4},
				{2,3},
				{2,4},
				{3,4},
		};
		int[] vexs = {0,1,2,3,4};
		adjGraph.CreateGraph(datas, vexs, adjGraph);
		adjGraph.print_Graph(adjGraph);
		System.out.println("");
		DFS dfs = new DFS(adjGraph.vexNodes.length);
		System.out.println("深度遍历");
		dfs.dfs(adjGraph, 0);
		
	}

}
