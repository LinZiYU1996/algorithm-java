package tree;

import java.util.Stack;

public class Traversal {
	
	
	/**
	 * 递归实现先序遍历
	 * @param root
	 */
	public static void preOrder(BinaryTreeNode root){
		if (root != null) {
			System.out.print(root.getData()+"  ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
		
	}
	
	/**
	 * 递归实现中序遍历
	 * @param root
	 */
	public static void inOrder(BinaryTreeNode root){
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData()+"  ");
			inOrder(root.getRight());
		}
		
	}
	
	/**
	 * 递归实现后序遍历
	 * @param root
	 */
	public static void postOrder(BinaryTreeNode root){
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData()+"  ");
		}
	}
	
	/**
	 * 非递归实现先序遍历
	 * @param root
	 */
	public static void NonpreOrder(BinaryTreeNode root){
		if (root == null) {
			System.out.println("空树");
		}
		Stack<BinaryTreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				System.out.print(root.getData());
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			root = root.getRight();
		}
	}
	
	/**
	 * 非递归实现中序遍历
	 * @param root
	 */
	public static void NoninOrder(BinaryTreeNode root){
		if (root == null) {
			System.out.println("空树");
		}
		Stack<BinaryTreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			System.out.print(root.getData());
			root = root.getRight();
		}
		
		
	}
	
	
	/**
	 * 非递归后序遍历
	 * @param root
	 */
	public static void NonpostOrder(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("空树");
		}
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty()) {
					System.out.println("栈空");
				} else {
					if (stack.peek().getRight() == null) {
						root = stack.pop();
						System.out.print(root.getData());
						if (root == stack.peek().getRight()) {
							System.out.print(stack.peek().getData());
							stack.pop();
						}
					}
					if (stack.isEmpty()) {
						root = stack.peek().getRight();
					}else {
						root = null;
					}
					
					
				}
			}
			
		}
		
		
	}
	

	public static void main(String[] args) {
			int[] num = {1,2,3,4,5,6,7};
			BinaryTreeNode root = CreateTree.createTree(num);
			System.out.println("先序遍历:");
			Traversal.preOrder(root);
			System.out.println("");
			System.out.println("中序遍历:");
			Traversal.inOrder(root);
			System.out.println("");
			System.out.println("后序遍历");
			Traversal.postOrder(root);
//			Traversal.NonpreOrder(root);
//			Traversal.NoninOrder(root);
			Traversal.NonpostOrder(root);
	}

}
