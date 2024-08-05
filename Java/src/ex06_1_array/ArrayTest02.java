package ex06_1_array;

import java.util.Scanner;

public class ArrayTest02 {

	public static void main(String[] s) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		int total = 0;
		
		System.out.print("정수 5개를 입력하세요>");
		for(int i = 0 ; i < 5; i++) {
		arr[i] = sc.nextInt();
		}
		
		/*
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		arr[4] = sc.nextInt();
		*/
		
		for (int i = 0 ; i < arr.length ; i++) {
			total += arr[i];
		}
		
		//double average = (double) total / 5;
		double average = (double) total / arr.length;
		
		System.out.println("합 = " + total);
		System.out.println("평균 = " + average);
		
		sc.close();
	}
}
