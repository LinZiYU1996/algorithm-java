package sort;

/**
 * 快速排序
 * @author linziyu
 *
 */
public class Sort05 {
	
	public void Sort(int[] data,int s,int t) {
		int i = s;
		int j = t;
		int temp;
		if (s < t) {
			temp = data[s];
			while (i != j) {
				while (j>i && data[j] >= temp) {
					j--;
				}
				data[i] = data[j];
				while (i<j && data[i] <= temp) {
					i++;
				}
				data[j] = data[i];
			}
			data[i] = temp;
			Sort(data, s, i-1);
			Sort(data, i+1, t);
		}
	}
	
	public static void main(String[] args) {
		int[] data = {0,5,4,3,2,1,0,-1};
		Sort05 sort05 = new Sort05();
		sort05.Sort(data, 0, data.length-1);
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}
	}

}
