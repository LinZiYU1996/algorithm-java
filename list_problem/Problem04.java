package list_problem;

import java.util.HashSet;

/**
 * 逆置单向链表
 * @author linziyu
 *
 */

public class Problem04 {
	
	public static ListNode ReverseList(ListNode headNode) {
		ListNode temp = null;
		ListNode nextNode = null;
		while (headNode != null) {
			nextNode = headNode.getNext();
			headNode.setNext(temp);
			temp = headNode;
			headNode = nextNode;
		}
		return temp;
		
	}
	
	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		ListNode h1 = new ListNode(3);
		ListNode h2 = new ListNode(5);
		ListNode h3 = new ListNode(11);
		h.setNext(h1);
		h1.setNext(h2);
		h2.setNext(h3);
		h3.setNext(null);
		Problem04 problem04 = new Problem04();
		ListNode node = problem04.ReverseList(h);
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
		
	}

}
