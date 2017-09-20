package classic_algorithms;

/**
 * 多源最短路径
 * @author linziyu
 *
 */
public class Floyd {
	int[][] A = new int[100][100];
	int[][] path = new int[100][100];
	final int INF = 1000;
	public void floyd(MatrixGrapht matrixGrapht) {
		for(int i=0;i<matrixGrapht.vex_num;i++){
			for(int j=0;j<matrixGrapht.vex_num;j++){
				A[i][j] = matrixGrapht.edges[i][j];
				if (i != j && matrixGrapht.edges[i][j] < INF) {
					path[i][j] = i;
				}else {
					path[i][j] = -1;
				}
			}
		}
		for(int k=0;k<matrixGrapht.vex_num;k++){
			for(int i=0;i<matrixGrapht.vex_num;i++){
				for(int j=0;j<matrixGrapht.vex_num;j++){
					if (A[i][j] > A[i][k]+A[k][j]) {
						A[i][j] = A[i][k]+A[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		DispALLPath(matrixGrapht, A, path);
	}
	public void DispALLPath(MatrixGrapht matrixGrapht,int[][] A,int[][] path) {
		int[] apath = new int[100];
		for(int i=0;i<matrixGrapht.vex_num;i++){
			for(int j=0;j<matrixGrapht.vex_num;j++){
			if (A[i][j] != 1000 && i != j) {
				System.out.printf("从%d到%d的最短路径长度为：%d\t",i,j,A[i][j]);
				int d=0;
				apath[d] = j;
				int k = path[i][j];
				while (k != -1 && k != i) {
						d++;
						apath[d] = k;
						k = path[i][k];
					}
				d++;
				apath[d] = i;
				System.out.printf("%d",apath[d]);
				for(int l = d-1;l>=0;l--){
						System.out.printf("--> %d",apath[l]);
					}
				System.out.println("");
				}
			}
			System.out.println("");
		}
		System.out.println("");
		}
	
	
	
	
	

	public static void main(String[] args) {
		final int INF = 1000;
		int[][] datas = {
				{0,4,6,6,INF,INF,INF},
				{INF,0,1,INF,7,INF,INF},
				{INF,INF,0,INF,6,4,INF},
				{INF,INF,2,0,INF,5,INF},
				{INF,INF,INF,INF,0,INF,6},
				{INF,INF,INF,INF,1,0,8},
				{INF,INF,INF,INF,INF,INF,0}
		};
		int[] vexs = {0,1,2,3,4,5,6};
		MatrixGrapht matrixGrapht = new MatrixGrapht(vexs.length, datas.length);
		matrixGrapht.CreateGraph(matrixGrapht, datas);
		Floyd floyd = new Floyd();
		floyd.floyd(matrixGrapht);
	}

}
