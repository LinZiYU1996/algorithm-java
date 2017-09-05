package queue;
/**
 * 循环数组实现队列
 * @author linziyu
 *
 */

public class ArrayQueue {
	
	private int front;
	private int rear;
	private int capacity;
	private int[] array;
	
	/**
	 * 初始化队列
	 * @param size
	 */
	public ArrayQueue(int size) {
		capacity = size;
		front = -1;
		rear = -1;
		array = new int[size];
	}

	/**
	 * 创建队列，大小为size
	 * @param size
	 * @return
	 */
	public ArrayQueue createQueue(int size){
		return new ArrayQueue(size);
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return front == -1;
	}
	
	/**
	 * 判断队列是否已满
	 * @return
	 */
	public boolean isFull(){
		return rear+1%capacity == front;
	}
	
	/**
	 * 获取队列大小
	 * @return
	 */
	public int getQueueSize(){
		return (capacity-front+rear+1%capacity);
	}
	
	
	/**
	 * 数据进队列
	 * @param data
	 */
	public void enQueue(int data){
		if (isFull()) {
				System.out.println("overflow");
		} else {
			rear = (rear+1)%capacity;
			array[rear] = data;
			if (front == -1) {
				front = rear;
			}
		}
		
	}
	
	
	public int deQueue(){
		Integer data =  null;
		if (isEmpty()) {
			System.out.println("empty");
		} else {
			
			data = array[front];
			if (front == rear) {
				front = rear - 1;
				
			} else {
				front = (front+1)%capacity;
				
			}
			return data;
		}
		return data;
		
	}
	
	
	
	public static void main(String[] args) {
			ArrayQueue arrayQueue = new ArrayQueue(10);
			arrayQueue.enQueue(1);
			arrayQueue.enQueue(10);
			System.out.println(arrayQueue.deQueue());
			System.out.println(arrayQueue.deQueue());
		
	}

}
