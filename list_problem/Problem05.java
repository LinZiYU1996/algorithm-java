package list_problem;
/**
 * 找链表中间结点
 * @author linziyu
 *
 */

public class Problem05 {
	
	public static ListNode FindMiddle(ListNode headNode) {
			ListNode ptr1x,ptr2x; //一个指针比另一个快一倍
			ptr1x = ptr2x = headNode;
			int i = 0;
			while (ptr1x.getNext() != null) {
				if (i == 0) {
					ptr1x = ptr1x.getNext();
					i = 1;
				} else if (i == 1) {
					ptr1x = ptr1x.getNext();
					ptr2x = ptr2x.getNext();
					i = 0;
				}
				
			}
		return ptr2x;
		
	}

	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		ListNode h1 = new ListNode(3);
		ListNode h2 = new ListNode(5);
		ListNode h3 = new ListNode(11);
		ListNode h4 = new ListNode(15);
		h.setNext(h1);
		h1.setNext(h2);
		h2.setNext(h3);
		h3.setNext(h4);
		h4.setNext(null);
		Problem05 problem05 = new Problem05();
		ListNode node = problem05.FindMiddle(h);
		System.out.println(node.getData());
		
	}

}
