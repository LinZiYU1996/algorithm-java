package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem10 {

	/**
	 * 非递归获取满结点的个数
	 * @param root
	 * @return
	 */
	public static int getFullNodes(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		BinaryTreeNode temp;
		int count = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.getLeft() != null && temp.getRight() != null) {
				count++;
			}
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
			
		}
		return count;
		
	}
	
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,9};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem10.getFullNodes(root));
	}

}
