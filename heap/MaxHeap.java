package heap;
/**
 * 大根堆建立以及堆排序
 * @author linziyu
 *
 */

public class MaxHeap {
	


/**
 * 堆排序
 * @param array
 */
public static void heapSort(int[] array) {  
    if (array == null || array.length <= 1) {  
        return;  
    }  

    buildMaxHeap(array);  //建立大根堆

    for (int i = array.length - 1; i >= 1; i--) {  
        ArrayUtils.exchangeElements(array, 0, i);  

        maxHeap(array, i, 0);  
    }  
}  

/**
 * 建立大根堆
 * @param array
 */
private static void buildMaxHeap(int[] array) {  
    if (array == null || array.length <= 1) {  
        return;  
    }  

    int half = array.length / 2;  
    for (int i = half; i >= 0; i--) {  
        maxHeap(array, array.length, i);  
    }  
}  


/**
 * 堆化
 * @param array
 * @param heapSize
 * @param index
 */
private static void maxHeap(int[] array, int heapSize, int index) {  
    int left = index * 2 + 1;  
    int right = index * 2 + 2;  

    int largest = index;  
    if (left < heapSize && array[left] > array[index]) {  
        largest = left;  
    }  

    if (right < heapSize && array[right] > array[largest]) {  
        largest = right;  
    }  

    if (index != largest) {  
        ArrayUtils.exchangeElements(array, index, largest);  

        maxHeap(array, heapSize, largest);  
    }  
}  
	
	
	

	public static void main(String[] args) {
		  int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };  
		  
          System.out.println("Before heap:");  
          ArrayUtils.printArray(array);  

          heapSort(array);  

          System.out.println("After heap sort:");  
          ArrayUtils.printArray(array);  
	}

}
