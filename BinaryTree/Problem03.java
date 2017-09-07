package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem03 {
	
	/**
	 * 插入数据往二叉树
	 * @param root
	 * @param data
	 */
	public static void InsertTree(BinaryTreeNode root,int data) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		BinaryTreeNode temp;
		if (newNode == null) {
			System.out.println("Memomy");
			return;
		}
		if (root == null) {
			root = newNode;
			return;
		}
		
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			} else {
				temp.setLeft(newNode);
				return;
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			} else {
				temp.setRight(newNode);
				return;
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		int[] array = {1,3,55,12,77,49,96};
		BinaryTreeNode root = CreateTree.createTree(array);
		Traversal.inOrder(root);
		Problem03.InsertTree(root, 111);
		System.out.println("");
		Traversal.inOrder(root);
		
		
	}

}
