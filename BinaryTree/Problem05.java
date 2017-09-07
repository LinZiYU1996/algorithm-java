package tree;

public class Problem05 {
	
	
	/**
	 * 递归删除二叉树
	 * @param root
	 */
	public static void deleteTree(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root = null;
	}

	public static void main(String[] args) {
		int[] array = {1,3,55,12,77,49,96};
		BinaryTreeNode root = CreateTree.createTree(array);
		Traversal.inOrder(root);
		Problem05.deleteTree(root);
		System.out.println("");
		Traversal.inOrder(root);
	}

}
