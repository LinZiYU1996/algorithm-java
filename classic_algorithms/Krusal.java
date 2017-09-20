package classic_algorithms;

/**
 * Krusal算法
 * @author linziyu
 *
 */
public class Krusal {
	
	/**
	 * 直接插入排序
	 * @param nodes
	 * @param num
	 */
	public void Sorted(Node[] nodes,int num) {
		Node temp = new Node();
		int j;
		for(int i=0;i<num;i++){
			temp = nodes[i];
			j = i-1;
			while (j >= 0 && temp.weight < nodes[j].weight) {
				nodes[j+1] = nodes[j];
				j--;
			}
			nodes[j+1] = temp;
		}
		
	}
	
	public void krusal(MatrixGrapht matrixGrapht) {
		int[] vest = new int[100];
		Node[] nodes = new Node[100];
		
		int k = 0;
		for(int i=0;i<matrixGrapht.vex_num;i++){
			for(int j=0;j<=i;j++){
				nodes[k] = new Node();
				if(matrixGrapht.edges[i][j] != 0 && matrixGrapht.edges[i][j] != -1){
					
					nodes[k].start = i;
					nodes[k].end = j;
					nodes[k].weight = matrixGrapht.edges[i][j];
					k++;
				}
			}
		}
		Sorted(nodes, k);
		for(int i=0;i<matrixGrapht.vex_num;i++) {
			vest[i] = i;
		}
		
		k = 1;
		int j = 0;
		while (k < matrixGrapht.vex_num) {
			int u1 = nodes[j].start;
			int v1 = nodes[j].end;
			int sn1 = vest[u1];
			int sn2 = vest[v1];
			if (sn1 != sn2) {
				System.out.printf("边(%d,%d),权值为%d",u1,v1,nodes[j].weight);
				System.out.println("");
				k++;
				for(int i=0;i<matrixGrapht.vex_num;i++){
					if (vest[i] == sn2) {
						vest[i] = sn1;
					}
				}
			}
			j++;
			
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
//		matrixGrapht.printGrahp(matrixGrapht);
		Krusal krusal = new Krusal();
		krusal.krusal(matrixGrapht);
		
	}

}
