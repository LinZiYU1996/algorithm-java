 package graphproblems;

import java.util.LinkedList;
import java.util.Queue;

import org.omg.CORBA.Current;

public class Problem {
	int[] visted = new int[100];
	/**
	 * 判断是否为连通图（基于邻接表）
	 * @param adjGraph
	 * @param dfs
	 * @return
	 */
	public boolean isConnect(AdjGraph adjGraph,Util_DFS dfs) {
		dfs.dfs(adjGraph,0);
		for(int i=0;i<dfs.visited.length;i++){
			if (dfs.visited[i] == 0) {
				return false;
				
			}
		}
		return true;
	}
	
	/**
	 * 判断两个节点之间是否有路径
	 */
	
	public boolean hasPath(AdjGraph adjGraph,int u,int v) {
		int w;
		visted[u] = 1;
		EdgeNode node = adjGraph.vexNodes[Util_Graph.getPosition(adjGraph.vexNodes,u)].first_node;
		while (node != null) {
			w = node.adj_num;
			if (w == v) {
				return true;
			}
			if (visted[w] == 0) {
				hasPath(adjGraph, w, v);
			}
			node = node.next_node;
		}
		return false;
	}
	
	/**
	 * 两点之间路径(无向图)
	 * @param adjGraph
	 * @param u
	 * @param v
	 * @param path
	 * @param start
	 */
	public void FindPath(AdjGraph adjGraph,int u,int v,int[] path,int start) {
		visted[u] = 1;
		int w;
		path[start] = u;
		start++;
		if (u == v) {
			for(int i=0;i<start;i++){
				System.out.println(path[i]);
			}
		}
		EdgeNode node = adjGraph.vexNodes[Util_Graph.getPosition(adjGraph.vexNodes, u)].first_node;
		while (node != null) {
			 w = node.adj_num;
			 if (visted[w] == 0) {
				FindPath(adjGraph, w, v, path, start);
			}
			 node = node.next_node;
		}
	}
	
	/**
	 * 找出无向图两个节点之间所有路径
	 * @param adjGraph
	 * @param u
	 * @param v
	 * @param path
	 * @param start
	 */
	public void FindAllPath(AdjGraph adjGraph,int u,int v,int[] path,int start) {
		visted[u] = 1;
		path[start] = u;
		start++;
		if (u == v && start >=1) {
			for(int i=0;i<start;i++){
				System.out.print(path[i]);
			}
			System.out.println(" ");
		}
		
		EdgeNode node = adjGraph.vexNodes[Util_Graph.getPosition(adjGraph.vexNodes,u)].first_node;
		while (node != null) {
			int w = node.adj_num;
			if (visted[w] == 0) {
				FindAllPath(adjGraph, w, v, path, start);
			}
			node = node.next_node;
		}
		
		visted[u] = 0;
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		Problem p = new Problem();
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
//		adjGraph.print_Graph(adjGraph);
		System.out.println("");
		Util_DFS util_DFS = new Util_DFS(adjGraph.vexNodes.length);
//		System.out.println(p.isConnect(adjGraph, util_DFS));
//		System.out.println(p.hasPath(adjGraph, 0, 1));
		int[] path = new int[100];
//		p.FindPath(adjGraph, 0, 3, path, 0);
//		p.FindAllPath(adjGraph, 0, 3, path, 0);
		
	}

}
