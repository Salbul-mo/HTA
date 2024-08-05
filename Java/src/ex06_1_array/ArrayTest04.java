package ex06_1_array;

import java.util.Scanner;

public class ArrayTest04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] data = new int[5];
		
		System.out.print("정수 5개를 입력하시오>");
		for(int i = 0 ; i < data.length ; i++) {
			data[i] = sc.nextInt();
		}

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
		
		sc.close();
	}
}

