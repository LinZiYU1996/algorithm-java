package dlist;

/**
 * 双链表的基本操作
 * @author linziyu
 *
 */

public class Main_DLLNode {
	
	/**
	 * 输出双链表
	 * @param headNode //头节点
	 */
	public void printDllNode(DLLNode headNode) {
		while (headNode != null) {
			System.out.println(headNode.getData()+"   ");
			headNode = headNode.getNext();
		}
	}
	
	/**
	 * 返回链表长度
	 * @param headnode
	 * @return
	 */
	public int ListLength(DLLNode headnode){
		int length = 0;
		DLLNode currentNode = headnode;
		while (currentNode!=null) {
			length++;
			currentNode=currentNode.getNext();
		}
		return length;
		
	}
	
	/**
	 * 插入元素
	 * @param headNode  // 头节点
	 * @param nodeInsertTo  //插入节点
	 * @param position  //插入位置
	 * @return
	 */
	public DLLNode DLLInsert(DLLNode headNode,DLLNode nodeInsertTo,int position){
		if (headNode == null) {
			return headNode;
		}
		int size = ListLength(headNode);
		if (position<1 || position>size+1) {
			System.out.println("ERROR");
			return headNode;
		} 
			
		if (position == 1) {  //在第一个节点处插入
			nodeInsertTo.setNext(headNode);
			headNode.setPrevious(nodeInsertTo);
			return nodeInsertTo;
		} else {   //在中间或者结尾插入
			DLLNode previousNode = headNode;
			int count = 1;
			while (count < position-1) {
				previousNode = previousNode.getNext();
				count++;
			}
			DLLNode currentNode = previousNode.getNext();
			nodeInsertTo.setNext(currentNode);
			if (currentNode != null) {
				currentNode.setPrevious(nodeInsertTo);
			}
			previousNode.setNext(nodeInsertTo);
			nodeInsertTo.setPrevious(headNode);
			
		}
		return headNode;
		}
	
	
	/**
	 * 删除双链表节点
	 * @param headNode //头节点
	 * @param position  //删除位置
	 * @return
	 */
	public DLLNode DllDelete(DLLNode headNode,int position){
		int size = ListLength(headNode);
		if (position < 1 || position > size+1) {
			System.out.println("ERROR");
			return headNode;
		}
		if (position == 1) {  //删除链表第一个节点
			DLLNode currentNode = headNode.getNext();
			headNode = null;
			currentNode.setPrevious(null);
			return currentNode;
			
		} else {  //删除中间或最后节点
			DLLNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}
			DLLNode currentNode = previousNode.getNext();
			DLLNode laterNode = currentNode.getNext();
			previousNode.setNext(laterNode);
			if (laterNode != null) {
						//如果被删除节点的后继节点不是null节点，那么设置前驱
						//指针指向被删除节点的前驱节点
				laterNode.setPrevious(previousNode);
			}
			currentNode = null;
		}
		return headNode;
		
		
	}

}
