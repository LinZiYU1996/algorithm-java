package sort;

/**
 * 希尔排序
 * @author linziyu
 *
 */
public class Sort03 {
	
	public void Sort(int[] data,int n) {
		int d = n/2;
		int temp;
		while (d>0) {
			for(int i=d;i<n;i++){
				temp = data[i];
				int j = i-d;
				while (j>=0 && temp < data[j]) {
					data[j+d] = data[j];
					j = j-d;
				}
				data[j+d] = temp;
			}
			d = d/2;
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] data = {0,5,4,3,2,1,0};
		Sort03 sort03 = new Sort03();
		int n = data.length;
		sort03.Sort(data, n);
		for(int i=0;i<n;i++){
			System.out.println(data[i]);
		}
	}

}
