package sort;

/**
 * 折半排序
 * @author linziyu
 *
 */
public class Sort02 {
	
	public void Sort(int[] data,int n) {
		int temp,high,low;
		for(int i=1;i<n;i++){
			if (data[i-1] > data[i]) {
				temp = data[i];
				low = 0;
				high = i-1;
				while (low<=high) {
					int mid = (low+high)/2;
					if (data[mid] > temp) {
						high = mid-1;
					} else {
						low = mid+1;
					}
				}
				for(int j=i-1;j>=high;j--){
					data[j+1] = data[j];
				}
				data[high+1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] data = {0,5,4,3,2,1,0};
		Sort02 sort02 = new Sort02();
		int n = data.length;
		sort02.Sort(data, n);
		for(int i=0;i<n;i++){
			System.out.println(data[i]);
		}
	}

}
