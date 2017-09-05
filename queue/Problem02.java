package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * 
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个
 * ： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *  {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * 
 * 
 * 
 * @author linziyu
 *
 */



public class Problem02 {

	
	public static Vector<Integer> maxSlidingWindow(int[] nums ,int k){
		Deque<Integer> deque = new LinkedList<>();
		Vector<Integer> vector = new Vector<>();
		Queue<Integer> queue = new LinkedList<>();
		int len = nums.length;
		for(int  i=0;i<k;i++){
			while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
								deque.pollLast();							
			}
			deque.addLast(i);
		}
		
		for(int i=k;i<len;i++){
			
			vector.add(nums[deque.getFirst()]);
			while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
				deque.pollLast();
			}
			
			
			deque.addLast(i);
			
		}
		
		vector.add(nums[deque.getFirst()]);
		return vector;
	}
	
	public static void main(String[] args) {
			int[] nums = {2,3,4,2,6,2,5,1};
			Vector<Integer> vector = Problem02.maxSlidingWindow(nums, 3);
			System.out.println(vector.size());
			for(int i=0;i<vector.size();i++){
				System.out.println(vector.get(i));
			}
	}

}
