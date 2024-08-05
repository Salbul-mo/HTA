package ex06_1_array;

public class ArrayTest03 {

	public static void main(String[] args) {
		int[] data = { 20, 30, 40, 80, 10 };

		int max = data[0];
		int min = data[0];

		for (int i = 1; i < data.length; i++) {
			/*if (max < data[i]) {
				max = data[i];
			}
			*/
			max = max < data[i] ? data[i] : max ;
			/*if (min > data[i]) {
				min = data[i];
			}
			*/
			min = min > data[i] ? data[i] : min ;
		}

		//System.out.println("max = " + max + "\nmin = " + min);
		System.out.printf("%s = %d\n%s = %d","max",max,"min",min);
	}
}
