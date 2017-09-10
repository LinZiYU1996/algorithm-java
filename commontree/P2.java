package commontree;

public class P2 {
	
	/**
	 * 获取兄弟结点个数
	 * @param root
	 * @return
	 */
	public static int SiblingsCount(CommonTreeNode root){
		int count = 0;
		while (root.getNextSibling() != null) {
			count++;
			root = root.getNextSibling();
		}
		return count;
	}

	public static void main(String[] args) {
		CommonTreeNode root = new CommonTreeNode(1);
		CommonTreeNode c1 = new CommonTreeNode(3);
		CommonTreeNode c2 = new CommonTreeNode(5);
		CommonTreeNode c3 = new CommonTreeNode(7);
		CommonTreeNode c4 = new CommonTreeNode(9);
		root.setFirstChild(c1);
		c1.setNextSibling(c2);
		c2.setNextSibling(c3);
		c3.setFirstChild(c4);
		System.out.println(P2.SiblingsCount(c1));
		
		
	}

}
