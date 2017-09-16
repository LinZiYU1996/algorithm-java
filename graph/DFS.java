package graph;

import java.util.LinkedList;

/**
 * 基于邻接表实现深度和广度遍历
 * @author linziyu
 *
 */
public class DFS {
	
	class EdgeNode{  //边节点
		int adjvex; //链接的节点的值
		EdgeNode nextEdge; //邻接边
}

	class VexNode{  //顶点节点
	int data;  //顶点数据
	EdgeNode firstEdge;  //第一条邻接边
	boolean isVisted;  //记录是否访问过
	public boolean isVisted() {
		return isVisted;
	}
	public void setVisted(boolean isVisted) {
		this.isVisted = isVisted;
	}
	
}

	VexNode[] vexsarray ;  //顶点数组

	boolean[] isVisited = new boolean[100];
	
	public void linkLast(EdgeNode target,EdgeNode node) {
	while (target.nextEdge!=null) {
		target=target.nextEdge;
	}
	target.nextEdge=node;
}

	public int getPosition(int data) {
		for(int i=0;i<vexsarray.length;i++) {
			if (data==vexsarray[i].data) {
					return i;
			}
		}
			return -1;
}


	public void buildGraph(int[] vexs,int[][] edges ) {
	int vLen = vexs.length;
	int eLen = edges.length;
	vexsarray = new VexNode[vLen];
	
	for(int i=0;i<vLen;i++) {
		vexsarray[i] = new VexNode();
		vexsarray[i].data = vexs[i];
		vexsarray[i].firstEdge = null;
	}
	
	for(int i=0;i<eLen;i++) {
		
		int a = edges[i][0];
		int b = edges[i][1];
		
		int start = getPosition(a);
		int end = getPosition(b);
		
		EdgeNode edgeNode = new EdgeNode();
		edgeNode.adjvex = end;
		
		if (vexsarray[start].firstEdge == null) {
			vexsarray[start].firstEdge = edgeNode;
		} else {
			linkLast(vexsarray[start].firstEdge,edgeNode);
		}
	}
}


	public void printGraph() {
	for(int i=0;i<vexsarray.length;i++) {
		System.out.printf("%d--",vexsarray[i].data);
		EdgeNode node = vexsarray[i].firstEdge;
		while (node!=null) {
			System.out.printf("%d--",vexsarray[node.adjvex].data);
			node = node.nextEdge;
		}
		System.out.println("\n");
	}
}

	
	
	
	
	int[] visited = new int[100];  //记录数组
	/**
	 * 深度遍历
	 * @param vex
	 */
	public void dfs(int vex) {
		int w;
		EdgeNode edgeNode;
		visited[vex] = 1;
		System.out.print(vex+"  ");
		edgeNode = vexsarray[getPosition(vex)].firstEdge;
		while (edgeNode != null) {
			w = edgeNode.adjvex;
			if (visited[w] ==0) {
				dfs(vexsarray[w].data);
			}
			edgeNode = edgeNode.nextEdge;
		}
		
	}
	
	
	public void bfs(int vex) {
		VexNode start = vexsarray[getPosition(vex)];
		LinkedList<VexNode> qLinkedList = new LinkedList<>();
		start.setVisted(true);
		qLinkedList.add(start);
		System.out.print(start.data+" ");
		VexNode currvex;
		while (!qLinkedList.isEmpty()) {
			currvex = qLinkedList.remove(0);
			EdgeNode node = currvex.firstEdge;
			while (node != null) {
				if (vexsarray[node.adjvex].isVisted == false) {
					System.out.print(vexsarray[node.adjvex].data+" ");
					vexsarray[node.adjvex].setVisted(true);
					qLinkedList.add(vexsarray[node.adjvex]);
				}
				node = node.nextEdge;
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		int[] vexs = {0,1,2,3,4};
		int[][] edges = {
				{0,1},
				{0,3},
				{1,0},
				{1,2},
				{2,1},
				{2,3},
				{2,4},
				{3,0},
				{3,2},
				{3,4},
				{4,2},
				{4,3},
				
		};
		DFS dfs = new DFS();
		dfs.buildGraph(vexs, edges);
		dfs.printGraph();
		System.out.println("深度遍历");
		dfs.dfs(0);
		System.out.println("");
		System.out.println("广度遍历");
		dfs.bfs(0);
	
	}

}
