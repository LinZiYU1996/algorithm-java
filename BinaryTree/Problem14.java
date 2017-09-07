package tree;

public class Problem14 {
	
	/**
	 * 是否存在路径和等于给定参数num
	 * @param root
	 * @param num
	 * @return
	 */
	public static boolean hasThePath(BinaryTreeNode root,int num) {
		if (root == null) {
			return(num == 0);
		} else {
			int sum = num - root.getData();
			return (hasThePath(root.getLeft(),sum) || hasThePath(root.getRight(), sum));
		}
		
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem14.hasThePath(root, 7));
	}

}
