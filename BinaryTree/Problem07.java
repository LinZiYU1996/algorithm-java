package tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.lang.model.element.QualifiedNameable;

public class Problem07 {

	
	/**
	 * 递归求二叉树深度
	 * @param root
	 * @return
	 */
	public static int getHightFromTree(BinaryTreeNode root) {
		int lefthight,righthight;
		if (root == null) {
			return 0;
		} else {
			lefthight = getHightFromTree(root.getLeft());
			righthight = getHightFromTree(root.getRight());
			if (lefthight > righthight) {
				return lefthight+1;
			} else {
				return righthight+1;
			}
			
		}
	}
	
	/**
	 * 非递归求二叉树深度
	 * @param root
	 * @return
	 */
	public static int  getHeight(BinaryTreeNode root) {
		int level = 1;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if (root == null) {
			return 0;
		}
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
					level++;
				}
			} else {
				if (root.getLeft() != null) {
					queue.add(root.getLeft());
				}
				if (root.getRight() != null) {
					queue.add(root.getRight());
				}
			}
			
		}
		return level;
		
	}
	
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,9};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem07.getHightFromTree(root));
		System.out.println(Problem07.getHeight(root));
	}

}
