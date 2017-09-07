package tree;

import java.util.LinkedList;

/**
 * 将给定数组里的元素创建成二叉树
 * @author linziyu
 *
 */

public class CreateTree {
		
	public static BinaryTreeNode createTree(int[] array){
		
		LinkedList<BinaryTreeNode> nodeLists = new LinkedList<>();
		for(int i=0;i<array.length;i++){
			nodeLists.add(new BinaryTreeNode(array[i]));
		}
		
		if (nodeLists.size() > 0) {
			for(int j=0;j<array.length/2-1;j++){
				if (nodeLists.get(2*j+1) != null) {
					nodeLists.get(j).setLeft(nodeLists.get(2*j+1));
				}
				if (nodeLists.get(2*j+2) != null) {
					nodeLists.get(j).setRight(nodeLists.get(2*j+2));
				}
			}
			
			int lastIndex = array.length/2-1;
			nodeLists.get(lastIndex).setLeft(nodeLists.get(lastIndex*2+1));
			if (array.length%2 == 1) {
				nodeLists.get(lastIndex).setRight(nodeLists.get(lastIndex*2+2));
				
			}
			
		}
		return nodeLists.get(0);
		
	}
	
	
	
}
