package commontree;

public class P1 {
		/**
		 * 获取所有结点和
		 * @param root
		 * @return
		 */
	public static int getNums(CommonTreeNode root){
		if (root == null) {
			return 0;
		}
		return (root.getData()+getNums(root.getFirstChild())+getNums(root.getNextSibling()));
		
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
			System.out.println(P1.getNums(root));
	}
}
