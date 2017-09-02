package list_problem;


/**
 * 查找链表倒数第n个结点
 * @author linziyu
 *
 */
public class Problem02 {
	
	/**
	 * 同时使用两个指针进行统计
	 * @param headNode
	 * @param n
	 * @return
	 */
	public ListNode NthNodeFromEnd(ListNode headNode,int n) {
		ListNode pTemp = headNode;
		ListNode PNthNode = null;
		for(int count = 1;count < n;count++){
			if (pTemp != null) {
				pTemp = pTemp.getNext();
			}
		}
		while (pTemp != null) {
			if (PNthNode == null) {
				PNthNode = headNode;
			} else {
				PNthNode = PNthNode.getNext();
			}
			pTemp = pTemp.getNext();
		}
		if (PNthNode != null) {
			return PNthNode;
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
			ListNode head = new ListNode(1);
			ListNode h1 = new ListNode(5);
			ListNode h2 = new ListNode(7);
			head.setNext(h1);
			h1.setNext(h2);
			h2.setNext(null);
			Problem02 problem02 = new Problem02();
			ListNode node = problem02.NthNodeFromEnd(head,2);
			System.out.println(node.getData());
	}

}


//class  ListNode{
//	private Integer data;
//	private ListNode next;
//	public ListNode(Integer data) {
//			this.data = data;
//	}
//	public Integer getData() {
//		return data;
//	}
//	public void setData(Integer data) {
//		this.data = data;
//	}
//	public ListNode getNext() {
//		return next;
//	}
//	public void setNext(ListNode next) {
//		this.next = next;
//	}
//	
//}