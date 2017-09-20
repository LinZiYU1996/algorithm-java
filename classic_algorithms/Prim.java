package classic_algorithms;


/**
 * Prim算法求解最小生成树
 * @author linziyu
 *
 */
public class Prim {
	
	
	int[] lowest = new int[100];
	int[] cloest = new int[100];
	public void prim(MatrixGrapht matrixGrapht,int v) {
		for(int i=0;i<matrixGrapht.vex_num;i++){
			lowest[i] = matrixGrapht.edges[v][i];
			cloest[i] = v;
		}
		for(int i=1;i<matrixGrapht.vex_num;i++){
			int min = 100;
			int k = -1;
			for(int j=0;j<matrixGrapht.vex_num;j++){
				if (lowest[j] > 0 && lowest[j] < min) {
					min = lowest[j];
					k = j;
				}
			}
			System.out.printf("边(%d,%d),权值为%d",cloest[k],k,min);
			System.out.println("");
			lowest[k] = 0;
			for(int p=0;p<matrixGrapht.vex_num;p++){
				if (matrixGrapht.edges[k][p] > 0 && matrixGrapht.edges[k][p] < lowest[p]) {
					lowest[p] = matrixGrapht.edges[k][p];
					cloest[p] = k;
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		int[][] datas = {
				{0,1,3,4,7},
				{1,0,2,-1,-1},
				{3,2,0,5,8},
				{4,-1,5,0,6},
				{7,-1,8,6,0}
				
		};
		int[] vexs = {0,1,2,3,4}; 
		MatrixGrapht matrixGrapht = new MatrixGrapht(vexs.length,datas.length);
		matrixGrapht.CreateGraph(matrixGrapht, datas);
		matrixGrapht.printGrahp(matrixGrapht);
		Prim prim = new Prim();
		prim.prim(matrixGrapht, 0);
		
	}

}
