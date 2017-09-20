package graphproblems;



public class AdjGraph {

	VexNode[] vexNodes;
	
	
	public void CreateGraph(int[][] datas,int[] vexs,AdjGraph adjGraph) {
		adjGraph.vexNodes = new VexNode[vexs.length];
		for(int i=0;i<adjGraph.vexNodes.length;i++) {
			adjGraph.vexNodes[i] = new VexNode();
			adjGraph.vexNodes[i].first_node = null;
			adjGraph.vexNodes[i].data = i;
		}
		for(int i=0;i<datas.length;i++) {
			int d1 = datas[i][0];
			int d2 = datas[i][1];
			int start = Util_Graph.getPosition(adjGraph.vexNodes, d1);
			int end = Util_Graph.getPosition(adjGraph.vexNodes, d2);
			EdgeNode node1 = new EdgeNode();
			node1.adj_num = end;
			if (adjGraph.vexNodes[start].first_node == null) {
				adjGraph.vexNodes[start].first_node = node1;
			} else {
				Util_Graph.addLast(adjGraph.vexNodes[start].first_node,node1);
			}
			
			EdgeNode node2 = new EdgeNode();
			node2.adj_num = start;
			if (adjGraph.vexNodes[end].first_node == null) {
				adjGraph.vexNodes[end].first_node = node2;
			}else {
				Util_Graph.addLast(adjGraph.vexNodes[end].first_node,node2);
			}
			
		}
	}
	
	public void print_Graph(AdjGraph adjGraph) {
		System.out.printf("List Graph:\n");
        for (int i = 0; i < adjGraph.vexNodes.length; i++) {
            System.out.printf("%d: ",adjGraph.vexNodes[i].data);//输出节点的位置和数据
            EdgeNode node = adjGraph.vexNodes[i].first_node;//得到节点的第一人连接边
            /*
             * 循环输出边数据
             */
            while (node != null) {
                System.out.printf("%d",adjGraph.vexNodes[node.adj_num].data);
                node = node.next_node;
            }
            System.out.printf("\n");
        }
		
		
	}
	
	
	
	
	
}
