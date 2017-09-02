package list_problem;

/**
 * 判断给定链表是以null结尾还是环
 * @author linziyu
 *
 */
public class Problem03 {
	
	/**
	 * 返回true是环，false不是环
	 * @param headNode
	 * @return
	 */
	public boolean Floyd(ListNode headNode) {
		if (headNode == null) {
			return false;
		}
		ListNode slowP = headNode;
		ListNode fastP = headNode;
		while (slowP.getNext() != null && fastP.getNext().getNext() != null) {
			slowP = slowP.getNext();
			fastP = fastP.getNext().getNext();
			if (slowP == fastP) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		ListNode h1 = new ListNode(3);
		ListNode h2 = new ListNode(5);
		ListNode h3 = new ListNode(11);
		h.setNext(h1);
		h1.setNext(h2);
		h2.setNext(h3);
		h3.setNext(h1);
		Problem03 problem03 = new Problem03();
		System.out.println(problem03.Floyd(h));;
	}

}
