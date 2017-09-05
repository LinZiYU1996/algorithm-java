package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 逆置队列元素
 * @author linziyu
 *
 */
public class Problem01 {
	
	
	public static Queue<Integer> reverseQueue(Queue<Integer> queue){
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		return queue;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(5);
		queue.offer(9);
		Queue<Integer> queue2 = Problem01.reverseQueue(queue);
		while (!queue2.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}

}
