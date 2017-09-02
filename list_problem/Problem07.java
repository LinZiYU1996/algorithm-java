package list_problem;

/**
 * 判断链表数据是否为回文数
 * @author linziyu
 *
 */
public class Problem07 {
	
	public static boolean isPlalindrome(ListNode head) {
		ListNode middleNode = Problem05.FindMiddle(head);  //找出中间结点
		ListNode reverNode = Problem04.ReverseList(middleNode.getNext()); //逆置后半部分
		while (head != middleNode && reverNode != null) {
			if (head.getData() != reverNode.getData()) {  //前后部分进行对比
				ListNode returnNode = Problem04.ReverseList(reverNode);
				middleNode.setNext(returnNode);
				return false;
			}
			head = head.getNext();
			reverNode = reverNode.getNext();
		}
		return true;
		
	}

	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		ListNode h1 = new ListNode(3);
		ListNode h2 = new ListNode(5);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(1);
		h.setNext(h1);
		h1.setNext(h2);
		h2.setNext(h3);
		h3.setNext(h4);
		h4.setNext(null);
		System.out.println(Problem07.isPlalindrome(h));
		while (h != null) {
			System.out.println(h.getData());
			h = h.getNext();
		}
	}

}
