package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem02 {

	public static boolean FindInTree(int data,BinaryTreeNode root) {
		boolean temp;
		if (root == null) {
			System.out.println("Problem02.FindInTree()");
			return false;
		} else {
			if (data == root.getData()) {
				return true;
			}else {
				temp = FindInTree(data, root.getLeft());
				if (temp != true) {
					return temp;
				} else {
					return FindInTree(data, root.getRight());
				}
			}
		}
	}
	
	/**
	 * 非递归搜索元素
	 * @param root
	 * @param data
	 * @return
	 */
	public static boolean FindByLevel(BinaryTreeNode root,int data) {
		BinaryTreeNode temp;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.getData() == data) {
				return true;
			}
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		int[] array = {1,3,55,12,77,49,96};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem02.FindByLevel(root, 96));
	}

}
