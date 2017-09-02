package list_problem;

import java.util.EmptyStackException;

/**
 * 链表实现栈
 * @author linziyu
 *
 */


public class Problem01 {
	
	private ListNode headNode;
	public Problem01() {
		// TODO Auto-generated constructor stub
		this.headNode = new ListNode(null);
	}
	
	/**
	 * 数据进栈
	 * @param data
	 */
	public void Push(int data){
		if (headNode == null) {
			headNode = new ListNode(data);
		} else if(headNode.getData() == null) {
			headNode.setData(data);
		} else {
			ListNode node = new ListNode(data);
			node.setNext(headNode);
			headNode = node;
		}
	}
	
	/**
	 * 返回栈顶元素
	 * @return
	 */
	public int Top() {
		if (headNode == null) {
			return 0;
		} else {
			return headNode.getData();
		}
	}
	
	/**
	 * 判断栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		if (headNode == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 删除栈
	 */
	public void deleteStack() {
		headNode = null;
	}
	
	/**
	 * 元素出栈
	 * @return
	 */
	public int Pop(){
		if (headNode == null) {
			throw new EmptyStackException();
		} else {
			int data = headNode.getData();
			headNode = headNode.getNext();
			return data;
		}
	}
	

	public static void main(String[] args) {
			Problem01 problem01 = new Problem01();
			problem01.Push(5);
			problem01.Push(7);
			problem01.Push(11);
			while (!problem01.isEmpty()) {
				System.out.println(problem01.Pop());
			}
	}

}

/**
 * 链表结点
 * @author linziyu
 *
 */
class  ListNode{
	private Integer data;
	private ListNode next;
	public ListNode(Integer data) {
			this.data = data;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
}