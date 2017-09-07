package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem01 {
	
	/**
	 * 递归实现找出二叉树最大值
	 * @param root
	 * @return
	 */
	public static int FindMax(BinaryTreeNode root) {
		int root_val,left,rigth,max = Integer.MIN_VALUE;
		if (root != null) {
			root_val = root.getData();
			left = FindMax(root.getLeft());
			rigth = FindMax(root.getRight());
			if (left > rigth) {
				max = left;
			} else {
				max = rigth;
			}
			
			if (max < root_val) {
				max = root_val;
			}
		}
		return max;
	}
	
	/**
	 * 非递归实现查找最大值
	 * @param root
	 * @return
	 */
	public static int FindMaxLevel(BinaryTreeNode root) {
		BinaryTreeNode temp;
		int max = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (max < temp.getData()) {
				max = temp.getData();
			}
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
		}
		return max;
		
	}
	
	

	public static void main(String[] args) {
			int[] array = {1,3,55,12,77,49,96};
			BinaryTreeNode root = CreateTree.createTree(array);
			System.out.println(Problem01.FindMax(root));
			System.out.println(Problem01.FindMaxLevel(root));
	}

}
