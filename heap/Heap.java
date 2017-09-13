package heap;

public class Heap {
		int[] array;
		int count;
		int capacity;
		int heap_type;
		public Heap(int capacity) {
			this.capacity = capacity;
			this.count = 0;
			this.array = new int[capacity];
		}
		
		public  int Parent(int i) {
			if (i < 0 || i >= this.count) {
				return -1;
			}
			return i-1/2;
		}
		
		public int Left(int i) {
			int left = 2*i+1;
			if (left >= this.count) {
				return -1;
			}
			return left;
		}
		public int Right(int i) {
			int right = 2*i+2;
			if (right >= this.count) {
				return -1;
			}
			return right;
		}
		public int getMax() {
			if (this.count == 0) {
				return -1;
			}
			return this.array[0];
		}
		public void Percplate(int i) {
			int l,r,max,temp;
			l = Left(i);
			r = Right(i);
			if (l != -1 && this.array[l] > this.array[i]) {
				max = l;
			} else {
				max = i;
			}
			if (r != -1 && this.array[r] > this.array[max]) {
				max = r;
			}
			if (max != i) {
				temp = this.array[i];
				this.array[i] = this.array[max];
				this.array[max] = temp;
				
			}
			
			Percplate(max);
		}
		
		public void buildHeap(int[] nums,Heap heap,int n) {
			if (heap == null) {
				return;
			}
			while (n > this.capacity) {
				break;
			}
			for(int i=0;i<n;i++){
				heap.array[i] = nums[i];
			}
			this.count = n;
			for(int i=(n-1)/2;i>=0;i--){
				heap.Percplate(i);
			}
			
		}
		public static void main(String[] args) {
			int[] n1 = {1,5,0,9,6,10};
			Heap h = new Heap(100);
			h.buildHeap(n1, h, 6);
			for(int i=0;i<n1.length;i++){
				System.out.println(n1[i]);
			}
	}
		
	
}
