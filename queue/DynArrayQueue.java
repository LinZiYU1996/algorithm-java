package queue;

/**
 * 动态循环数组实现队列
 * @author linziyu
 *
 */
public class DynArrayQueue {
	private int front;
	private int rear;
	private int capacity;
	private int[] array;
	
	
	/**
	 * 初始化队列
	 */
	public DynArrayQueue() {
		capacity = 1;
		front = -1;
		rear = -1;
		array = new int[1];
	}
	
	/**
	 * 返回队列
	 * @return
	 */
	public DynArrayQueue createDynArrayQueue(){
		return new DynArrayQueue();
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return (front == -1);
	}
	
	/**
	 * 判断是否队满
	 * @return
	 */
	public boolean isFull(){
		return (rear+1%capacity == front);
	}
	
	/**
	 * 返回队列元素个数
	 * @return
	 */
	public int getDynArrayQueueSize(){
		if (front == -1) {
			return 0;
		}
		int size = (capacity-front+rear+1)%capacity;
		if (size == 0) {
			return capacity;
		} else {
			return size;
		}
	}
	/**
	 * 扩大两倍数组大小
	 */
	public void resizeQueue(){
		int initCapacity = capacity;
		capacity*=2;
		int[] oldarray = array;
		array = new int[this.capacity];
		for(int i=0;i<oldarray.length;i++){
			array[i] = oldarray[i];
		}
		if (rear < front) {
			for(int i=0;i<front;i++){
				array[i+initCapacity] = this.array[i];
				array[i] = (Integer) null;
			}
			rear = rear + initCapacity;
		}
		
	}
	
	/**
	 * 进队
	 * @param data
	 */
	public void enQueue(int data){
		if (isFull()) {
			resizeQueue();
		}
		rear = (rear+1)%capacity;
		array[rear] = data;
		if (front == -1) {
			front = rear;
			
		}
	}
	
	/**
	 * 出队
	 * @return
	 */
	public int deQueue(){
		Integer data = null;
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
			DynArrayQueue queue = new DynArrayQueue();
			queue.enQueue(1);
			queue.enQueue(2);
			System.out.println(queue.deQueue());
			System.out.println(queue.deQueue());
	}

}
