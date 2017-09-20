package graphproblems;

public class Test {

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
		
		
		
	}

}
