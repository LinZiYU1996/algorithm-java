package sort;

/**
 * 冒泡排序
 * @author linziyu
 *
 */
public class Sort04 {
	
	public void Sort(int[] data,int n) {
		for(int i=0;i<n-1;i++){
			for(int j=n-1;j>i;j--){
				if (data[j] < data[j-1]) {
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] data = {0,5,4,3,2,1,0,-1};
		Sort04 sort04 = new Sort04();
		int n = data.length;
		sort04.Sort(data, n);
		for(int i=0;i<n;i++){
			System.out.println(data[i]);
		}
	}

}
