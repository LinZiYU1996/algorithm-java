package graphproblems;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 无向无权图两点间最短路径
 * @author linziyu
 *
 */
public class FindShortPath {
	
	int[] visited = new int[100]; 
	
	/**
	 * 判断两个点是否相连接
	 * @param v1
	 * @param v2
	 * @param adjGraph
	 * @return
	 */
	public boolean isConnect(int v1,int v2,AdjGraph adjGraph) {
		VexNode node1 = adjGraph.vexNodes[Util_Graph.getPosition(adjGraph.vexNodes, v1)];
		VexNode node2 = adjGraph.vexNodes[Util_Graph.getPosition(adjGraph.vexNodes, v2)];
		EdgeNode current = node1.first_node;
		while (current != null) {
			if (current.adj_num == node2.data) {
				return true;
			}
			current = current.next_node;
		}
		return false;
	}
	/**
	 * 两点间最短路径
	 * @param adjGraph
	 * @param u
	 * @param v
	 */
	public void ShortPath(AdjGraph adjGraph,int u,int v) {
		Stack<VexNode> stack = new Stack<>();
		LinkedList<VexNode> linkedList = new LinkedList<>();
		stack.push(adjGraph.vexNodes[u]);
		visited[u] = 1;
		while (!stack.isEmpty()) {
			VexNode current = stack.pop();
//			System.out.println(current.data+" /");
			EdgeNode node = current.first_node;
			linkedList.add(current);
			if (current.data == v) {
				break;
			}
			if (isConnect(current.data,v, adjGraph)) {
				stack.push(adjGraph.vexNodes[v]);
				linkedList.add(adjGraph.vexNodes[v]);
				break;
			}
			if (visited[node.adj_num] == 0) {
				visited[node.adj_num] = 1;
				stack.push(adjGraph.vexNodes[node.adj_num]);
			} else {
				node = node.next_node;
				visited[node.adj_num] = 1;
				stack.push(adjGraph.vexNodes[node.adj_num]);
			}
			
		}
		
		for(int i=0;i<linkedList.size();i++){
			System.out.println(linkedList.get(i).data);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
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
		AdjGraph adjGraph = new AdjGraph();
		adjGraph.CreateGraph(datas, vexs, adjGraph);
//		adjGraph.print_Graph(adjGraph);
		FindShortPath findShortPath = new FindShortPath();
		findShortPath.ShortPath(adjGraph, 0, 4);
//		System.out.println(findShortPath.isConnect(1, 3, adjGraph));
	}

}
