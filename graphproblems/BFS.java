package graphproblems;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度遍历
 * @author linziyu
 *
 */
public class BFS {
	
	
	int[] visited = new int[100];
	public void bfs(AdjGraph adjGraph,int vex) {
		Queue<VexNode> queue = new LinkedList<>();
		visited[vex] = 1;
		System.out.print(vex+" ");  
		queue.add(adjGraph.vexNodes[vex]);
		VexNode current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			EdgeNode node = current.first_node;
			while (node != null) {
				if (visited[adjGraph.vexNodes[node.adj_num].data] == 0) {
					System.out.print(adjGraph.vexNodes[node.adj_num].data+" ");
					visited[adjGraph.vexNodes[node.adj_num].data] = 1;
					queue.add(adjGraph.vexNodes[node.adj_num]);
				}
				node = node.next_node;
			}
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
		BFS bfs = new BFS();
		bfs.bfs(adjGraph, 0);
		
	}

}
