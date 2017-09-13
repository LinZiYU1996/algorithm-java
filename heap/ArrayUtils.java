package heap;
/**
 * 数组工具
 * @author linziyu
 *
 */

public class ArrayUtils {
		/**
		 * 格式输出数组元素
		 * @param array
		 */
	  public static void printArray(int[] array) {  
          System.out.print("{");  
          for (int i = 0; i < array.length; i++) {  
              System.out.print(array[i]);  
              if (i < array.length - 1) {  
                  System.out.print(", ");  
              }  
          }  
          System.out.println("}");  
      }  
	  
	  
	  /**
	   * 数据交换
	   * @param array
	   * @param index1
	   * @param index2
	   */
      public static void exchangeElements(int[] array, int index1, int index2) {  
          int temp = array[index1];  
          array[index1] = array[index2];  
          array[index2] = temp;  
      }  
}
