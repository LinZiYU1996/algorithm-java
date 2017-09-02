package list_problem;

/**
 * 合并两个有序链表，新的链表还是有序
 * @author linziyu
 *
 */
public class Problem06 {
	
	public ListNode MergeList(ListNode a,ListNode b) {
		ListNode res = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.getData() <= b.getData()) {
			res = a;
			res.setNext(MergeList(a.getNext(), b));
		} else {
			res = b;
			res.setNext(MergeList(a, b.getNext()));
		}
		return res;
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
		
		ListNode k = new ListNode(2);
		ListNode k1 = new ListNode(12);
		ListNode k2 = new ListNode(15);
		ListNode k3 = new ListNode(110);
		k.setNext(k1);;
		k1.setNext(k2);
		k2.setNext(k3);
		k3.setNext(null);
		Problem06 problem06 = new Problem06();
		ListNode node = problem06.MergeList(h, k);
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}

}
