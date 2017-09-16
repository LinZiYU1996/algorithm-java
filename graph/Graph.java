package graph;
/**
 * 实现图的邻接矩阵
 * @author linziyu
 *
 */

public class Graph {
	final int max = 100;
	int[][] edges = new int[max][max];  //边集合
	int[] vexs = new int[max];  //顶点集合
	int vex_nums; //顶点数量
	int edge_nums;  //边数量
	
	/**
	 * 生成图
	 * @param datas
	 * @param vexs
	 * @param graph
	 */
	public  void CreateGraph(int[][] datas,int[] vexs,Graph graph) {
		graph.vexs = vexs;
		for(int i=0;i<vexs.length;i++) {
			for (int j=0;j<vexs.length;j++) {
				graph.edges[i][j] = datas[i][j];
			}
		}
	}
	/**
	 * 输出图
	 * @param graph
	 */
	public  void printf(Graph graph) {
		for(int i=0;i<graph.vexs.length;i++) {
			for(int j=0;j<graph.vexs.length;j++) {
				if (graph.edges[i][j] == 1) {
					System.out.printf("%4d",graph.edges[i][j]);
				}
				else {
					System.out.printf("%4s","*");
				}
			}
			System.out.println("");
		}
	}
	
	
	

	public static void main(String[] args) {
			int[][] datas = {
					{0,1,1,0,0},
					{1,0,0,1,1},
					{1,0,0,0,0},
					{0,1,0,0,1},
					{0,1,0,1,0}
			};
			int[] vexs = {0,1,2,3,4};
			Graph graph = new Graph();
			graph.CreateGraph(datas, vexs, graph);
			graph.printf(graph);
	}

}
