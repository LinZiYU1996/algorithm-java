package tree;

public class Problem15 {
	
	/**
	 * 获取所有结点数据和
	 * @param root
	 * @return
	 */
	public static int  getNums(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		else {
			return (root.getData()+getNums(root.getLeft())+getNums(root.getRight()));
		}
	}
	
	

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem15.getNums(root));;
	}

}
