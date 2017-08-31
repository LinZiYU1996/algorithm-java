package linkList;

/**
 * 单链表操作
 * @author linziyu
 *
 */
public class List_Main_Method {
	
	
	/**
	 * 返回链表长度
	 * @param headnode
	 * @return
	 */
	public int ListLength(ListNode headnode){
		int length = 0;
		ListNode currentNode = headnode;
		while (currentNode!=null) {
			length++;
			currentNode=currentNode.getNext();
		}
		return length;
		
	}
	/**
	 * 往链表插入数据
	 * @param headNode 头节点
	 * @param nodeToInsert 插入节点
	 * @param position  插入位置
	 * @return
	 */
	public ListNode InsertLinkedList(ListNode headNode,ListNode nodeToInsert,int position){
		if (headNode == null) {  //链表为空插入
			return nodeToInsert;
		}
		int size = ListLength(headNode);
		if (position>size+1 || position<1) {
			System.out.println("ERROR");
			return headNode;
		}
		
		if (position == 1) {   //链表开头插入
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
			
		} else {   
			//在链表中间或末尾插入
			ListNode previousNode = headNode;
			int count = 1;
			while (count<position-1) {
				previousNode = previousNode.getNext();
				count++;
			}
			
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
			
		}
		
		return headNode;
		
	}
	
	/**
	 * 删除节点
	 * @param headNode 头节点
	 * @param position  删除节点
	 * @return
	 */
	public ListNode DeleteNodeFromLinkedList(ListNode headNode,int position){
		int size = ListLength(headNode);
		if (position>size || position<1) {
			System.out.println("ERROR");
			return headNode;
		}
		if (position == 1) { //删除头节点
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		} else {		//删除中间或者表尾节点
			ListNode previousNode = headNode;
			int count = 1;
			while (count<position) {
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
			
		}
		return headNode;
		
	}
	
	/**
	 * 输出链表数据
	 * @param headNode  头节点
	 */
	public void printList(ListNode headNode){
		while (headNode!=null){
			System.out.println(headNode.getData()+"  ");
			headNode = headNode.getNext();
		}
	}
	
	
	
}
