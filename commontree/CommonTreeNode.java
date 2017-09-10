package commontree;

/**
 * 通用树结点
 * @author linziyu
 *
 */
public class CommonTreeNode {

	public int data;
	public CommonTreeNode firstChild;  //第一个孩子
	public CommonTreeNode nextSibling;  //下一个兄弟
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public CommonTreeNode getFirstChild() {
		return firstChild;
	}
	public void setFirstChild(CommonTreeNode firstChild) {
		this.firstChild = firstChild;
	}
	public CommonTreeNode getNextSibling() {
		return nextSibling;
	}
	public void setNextSibling(CommonTreeNode nextSibling) {
		this.nextSibling = nextSibling;
	}
	public CommonTreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	
	
}
