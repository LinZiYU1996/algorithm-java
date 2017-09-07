package tree;

public class Problem11 {
	/**
	 * 求树的直径
	 * @param root
	 * @param diameter
	 * @return
	 */
	public static int DiameterTree(BinaryTreeNode root,int diameter) {
		int left,right;
		if (root == null) {
			return 0;
		}
		left = DiameterTree(root.getLeft(), diameter);
		right = DiameterTree(root.getRight(), diameter);
		if (left + right > diameter) {
			diameter = left + right;
		}
		return Math.max(left, right)+1;
		
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem11.DiameterTree(root, 0));
	}

}
