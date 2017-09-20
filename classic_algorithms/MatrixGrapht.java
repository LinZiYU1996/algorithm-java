package classic_algorithms;



public class MatrixGrapht {
	int vex_num;
	int edge_num;
	int[][] edges;
	int[]  vexs;
	public MatrixGrapht(int vex_num,int edge_num) {
		this.edge_num = edge_num;
		this.vex_num = vex_num;
		edges = new int[edge_num][edge_num];
		vexs = new int[vex_num];
	}
	
	public void CreateGraph(MatrixGrapht matrixGrapht,int[][] datas) {
		for(int i=0;i<datas.length;i++){
			for(int j=0;j<datas.length;j++){
				matrixGrapht.edges[i][j] = datas[i][j];
			}
		}
	}
	
	public void printGrahp(MatrixGrapht matrixGrapht) {
		for(int i=0;i<matrixGrapht.vex_num;i++){
			for(int j=0;j<matrixGrapht.vex_num;j++){
				if (matrixGrapht.edges[i][j] != -1) {
					System.out.print(matrixGrapht.edges[i][j]+"   ");
				} else {
					System.out.print("*"+"   ");
				}
			}
			System.out.println("");
			
		}
	}
	
	
	
	
	

	public static void main(String[] args) {
		final int INF = 1000;
		int[][] datas = {
				{INF,1,3,4,7},
				{1,INF,2,INF,INF},
				{3,2,INF,5,8},
				{4,INF,5,INF,6},
				{7,INF,8,6,INF}
				
		};
		int[] vexs = {0,1,2,3,4}; 
		MatrixGrapht matrixGrapht = new MatrixGrapht(vexs.length,datas.length);
		matrixGrapht.CreateGraph(matrixGrapht, datas);
		matrixGrapht.printGrahp(matrixGrapht);
	}

}
