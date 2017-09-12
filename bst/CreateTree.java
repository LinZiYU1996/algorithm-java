package bst;

public class CreateTree {
	
	/**
	 * 给定有序数组创建搜索二叉树
	 * @param datas
	 * @param start
	 * @param end
	 * @return
	 */
	public static BSTNode Create(int[] datas,int start,int end){
			BSTNode node;
			if (start > end) {
				return null;
			}
			node = new BSTNode();
			if (start == end) {
				node.setData(datas[start]);
				node.setLeft(null);
				node.setRight(null);
			}else {
				int mid = start + (end-start)/2;
				node.setData(datas[mid]);
				node.setLeft(Create(datas, start, mid-1));
				node.setRight(Create(datas, mid+1, end));
			}
			return node;
	}
	
	/**
	 * 中序遍历
	 * @param root
	 */
	public static void printf(BSTNode root){
		if (root != null) {
			printf(root.getLeft());
			System.out.print(root.getData()+" ");
			printf(root.getRight());
		}
		
	}
	
	public static void main(String[] args){
		int[] datas = {1,2,3,4,5,6,7};
		BSTNode node = CreateTree.Create(datas, 0, 6);
		printf(node);
	}
	
	
}
