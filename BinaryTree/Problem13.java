package tree;

public class Problem13 {
	
	/**
	 * 输出所有从根节点到叶子节点的路径
	 * @param root
	 */
	public static void printPath(BinaryTreeNode root) {
		int[] path = new int[256];
		printPath(root, path, 0);
	}
	
	public static void printPath(BinaryTreeNode root,int[] path,int lenPath) {
		if (root == null) {
			return;
		}
		path[lenPath] = root.getData();
		lenPath++;
		if (root.getLeft() == null && root.getRight() == null) {
			printArray(path,lenPath);
		}else {
			printPath(root.getLeft(), path, lenPath);
			printPath(root.getRight(), path, lenPath);
		}
		
	}

	public static void printArray (int[] ints,int len) {
		for(int i=0;i<len;i++){
			System.out.print(ints[i]);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		BinaryTreeNode root = CreateTree.createTree(array);
		Problem13.printPath(root);
	}

}
