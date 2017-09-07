package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem06 {
	
	/**
	 * 逆向输出二叉树
	 * @param root
	 */
	public static void LevelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		BinaryTreeNode temp;
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
			
			stack.push(temp.getData());
			
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+"  ");
			
			
		}
		
		
		
	}
	

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		BinaryTreeNode root = CreateTree.createTree(array);
		Problem06.LevelOrder(root);
	}

}
