package classic_algorithms;

/**
 * 单源最短路径算法
 * @author linziyu
 *
 */

public class Dijkstra {
	final int INF = 1000;
	int[] dist = new int[100];
	int[] path = new int[100];
	int[] S = new int[100];
	public void dijkstra(MatrixGrapht matrixGrapht,int v) {
		for(int i=0;i<matrixGrapht.vex_num;i++){
			dist[i] = matrixGrapht.edges[v][i];
			if (matrixGrapht.edges[v][i] < INF) {
				path[i] = v;
			}else {
				path[i] = -1;
			}
			S[i] = 0;
		}
		S[v] = 1;
		int u = 0;
		for(int i=0;i<matrixGrapht.vex_num-1;i++){
			int min = 1000;
			for(int j=0;j<matrixGrapht.vex_num;j++){
				if (min > dist[j] && S[j] == 0) {
					min = dist[j];
					u = j;
				}
			}
			System.out.printf("将顶点%d加入S中",u);
			System.out.println("");
			S[u] = 1;
			for(int j=0;j<matrixGrapht.vex_num;j++){
				if (S[j] == 0) {
					if (matrixGrapht.edges[u][j] < INF && dist[u] + matrixGrapht.edges[u][j] < dist[j]) {
						dist[j] = dist[u] + matrixGrapht.edges[u][j];
						path[j] = u;
					}
				}
			}
		}
		DispALLPath(matrixGrapht, dist, path, S, v);
		
		
	}
	
	public void DispALLPath(MatrixGrapht matrixGrapht,int[] dist,int[] path,int[] S,int v) {
		int[] apath = new int[100];
		for(int i=0;i<matrixGrapht.vex_num;i++){
			if (S[i] == 1&& i != v) {
				System.out.printf("从%d到%d的最短路径长度为：%d\t",v,i,dist[i]);
				int d=0;
				apath[d] = i;
				int k = path[i];
				if (k == -1) {
					System.out.println("没有路径\n");
				}else {
					while (k != v) {
						d++;
						apath[d] = k;
						k = path[k];
					}
					d++;
					apath[d] = v;
					System.out.printf("%d",apath[d]);
					for(int j = d-1;j>=0;j--){
						System.out.printf("--> %d",apath[j]);
					}
				}
			}
			System.out.println("");
		}
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
			Dijkstra dijkstra = new Dijkstra();
			dijkstra.dijkstra(matrixGrapht, 0);
			
	}

}
