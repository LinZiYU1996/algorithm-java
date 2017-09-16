package graph;

/**
 * 邻接表实现图
 *  * @author linziyu
 *
 */
public class AdjustGraoh {
	
	private class vexNode{
		int data;
		edgeNode firstNode;
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public edgeNode getFirstNode() {
			return firstNode;
		}
		public void setFirstNode(edgeNode firstNode) {
			this.firstNode = firstNode;
		}
		
	}
	private class edgeNode{
		int adj_vex;
		edgeNode nextNode;
		public int getAdj_vex() {
			return adj_vex;
		}
		public void setAdj_vex(int adj_vex) {
			this.adj_vex = adj_vex;
		}
		public edgeNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(edgeNode nextNode) {
			this.nextNode = nextNode;
		}
		
	}
	/**
	 * 将顶点进行连接
	 * @param target
	 * @param end
	 */
	public void addLast(edgeNode target,edgeNode end){
		while (target.nextNode != null) {
			target = target.nextNode;
		}
		target.nextNode = end;
	}
	
	/**
	 * 获取顶点位置
	 * @param data
	 * @return
	 */
	public int getPostio(int data) {
		
		for(int i=0;i<vexnodes.length;i++) {
				if (data==vexnodes[i].data) {
					return i;
				}
		}
		return -1;
	}
	
	vexNode[] vexnodes; //顶点数组
	
	public vexNode[] getVexnodes() {
		return vexnodes;
	}

	public void setVexnodes(vexNode[] vexnodes) {
		this.vexnodes = vexnodes;
	}
	/**
	 * 建立邻接表
	 * @param datas
	 * @param vexs
	 */
	public void Create(int[][] datas,int[] vexs){
		vexnodes = new vexNode[vexs.length];
		for(int i=0;i<vexs.length;i++) {
			vexnodes[i] = new vexNode();
			vexnodes[i].setFirstNode(null);
			vexnodes[i].setData(i);
		}
		for(int i=0;i<datas.length;i++){
					
					int i1 = datas[i][0];
					int i2 = datas[i][1];
					int start = getPostio(i1);
					int end = getPostio(i2);
					edgeNode node1 = new edgeNode();
					node1.adj_vex = end;
					if (vexnodes[start].firstNode == null) {
						vexnodes[start].firstNode = node1;
					} else {
						addLast(vexnodes[start].firstNode,node1);
					}
					
					edgeNode node2 = new edgeNode();
					node2.adj_vex = start;
					if (vexnodes[end].firstNode == null) {
						vexnodes[end].firstNode = node2;
					} else {
						addLast(vexnodes[end].firstNode,node2);
					}
				}
			}
		
	
	
	public void printf() {
		System.out.printf("List Graph:\n");
        for (int i = 0; i < vexnodes.length; i++) {
            System.out.printf("%d: ",vexnodes[i].data);//输出节点的位置和数据
            edgeNode node = vexnodes[i].firstNode;//得到节点的第一人连接边
            /*
             * 循环输出边数据
             */
            while (node != null) {
                System.out.printf("%d",vexnodes[node.adj_vex].data);
                node = node.nextNode;
            }
            System.out.printf("\n");
        }
	}
	
	public static void main(String[] args) {
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
		AdjustGraoh adjustGraoh = new AdjustGraoh();
		adjustGraoh.Create(datas, vexs);
		adjustGraoh.printf();
		
}
	
	
}


