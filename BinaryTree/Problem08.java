package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem08 {
	
	/**
	 * 获取最深结点
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode getDeepestNode(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		BinaryTreeNode temp = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
			
		}
		
		return temp;
		
	}
	
	

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,9};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem08.getDeepestNode(root).getData());
	}

}
