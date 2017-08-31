package hanoi;

/**
 * 汉诺塔问题
 * @author linziyu
 *
 */

public class HanOi {
	
	public static void TowersOfHanoi(int n,char frompeg,char toppeg,char auxpeg) {
		if (n == 1) {
			System.out.println("从"+frompeg+"移动盘子"+"到"+toppeg);
			return;
		}
		TowersOfHanoi(n-1, frompeg, toppeg, auxpeg);
		System.out.println("从"+frompeg+"移动盘子"+"到"+toppeg);
		TowersOfHanoi(n-1, auxpeg, toppeg, frompeg);
		
	}
	

	public static void main(String[] args) {
			TowersOfHanoi(3,'A','B','C');
	}

}
