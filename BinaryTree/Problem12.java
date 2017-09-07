package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem12 {
	
	/**
	 * 找出最大和的那层，根节点为0层
	 * @param root
	 * @return
	 */
	public static int FindMaxLevel(BinaryTreeNode root) {
		BinaryTreeNode temp;
		int level = 0,maxlevel = 0;
		int currentSum = 0,Maxsum = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp == null) {
					if (currentSum > Maxsum) {
						Maxsum = currentSum;
						maxlevel = level;
					}
				currentSum = 0;
				if (!queue.isEmpty()) {
					queue.add(null);

				}
				level++;
			} else {
				currentSum += temp.getData();
				if (temp.getLeft() !=null) {
					queue.add(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				}
			}
		}
		
		return maxlevel;
		
	}
	
	

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,100};
		BinaryTreeNode root = CreateTree.createTree(array);
		System.out.println(Problem12.FindMaxLevel(root));
	}

}
