package graphproblems;

public class Util_Graph {
	/**
	 * 邻接节点的连接
	 * @param target
	 * @param node
	 */
	public static void addLast(EdgeNode target,EdgeNode node) {
		while (target.next_node != null) {
			target = target.next_node;
		}
		target.next_node = node;
	}
	
	/**
	 * 返回数据在节点数组的位置
	 * @param vexs
	 * @param data
	 * @return
	 */
	public static int getPosition(VexNode[] vexs,int data) {
		for(int i=0;i<vexs.length;i++) {
			if (vexs[i].data == data) {
				return i;
			}
		}
		return -1;
	}
	
}
