package linkList;

public class Test_Slink {

	public static void main(String[] args) {
		ListNode headNode = new ListNode(1);
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(7);
		ListNode node3 = new ListNode(9);
		ListNode node4 = new ListNode(11);
		headNode.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(null);
		List_Main_Method method = new List_Main_Method();
		method.printList(headNode);
		method.InsertLinkedList(headNode, new ListNode(55), 3);
		System.out.println("---------------");
		method.printList(headNode);
		method.DeleteNodeFromLinkedList(headNode,5);
		System.out.println("---------------");
		method.printList(headNode);
	}

}
