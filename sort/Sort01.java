package sort;

/**
 * 插入排序
 * @author linziyu
 *
 */

public class Sort01 {
	
	
	public void Sort(int[] data,int n) {
		int j = 0,temp = 0;
		for(int i=1;i<n;i++){
			if (data[i-1] > data[i]) {
				temp = data[i];
				j = i-1;
				do {
					data[j+1]  = data[j];
					j--;
				} while (j>=0 && data[j] > temp);
				data[j+1] = temp; 
		}
	}
}
	
	
	

	public static void main(String[] args) {
			int[] data = {0,5,4,3,2,1,0};
			Sort01 sort01 = new Sort01();
			int n = data.length;
			sort01.Sort(data, n);
			for(int i=0;i<n;i++){
				System.out.println(data[i]);
			}
	}

}
