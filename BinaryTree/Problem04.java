package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem04 {

	/**
	 * 递归获取二叉树结点个数
	 * @param root
	 * @return
	 */
	public static int SizeOfNodesInTree(BinaryTreeNode root){
		if (root  == null) {
			return 0;
		} else {
			
			return(SizeOfNodesInTree(root.getLeft())+1+SizeOfNodesInTree(root.getLeft()));
			
		}
		
	}
	/**
	 * 非递归实现结点个数计算
	 * @param root
	 * @return
	 */
	public static int SizeOfTrees(BinaryTreeNode root) {
		BinaryTreeNode temp;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		int count = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			count++;
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
		int[] array = {1,3,55,12,77,49,96};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(SizeOfNodesInTree(root));
		System.out.println(SizeOfTrees(root));
	}

}
