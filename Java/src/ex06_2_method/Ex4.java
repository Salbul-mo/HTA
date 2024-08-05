package ex06_2_method;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		int[] arr = input();
		int max = max(arr);
		int min = min(arr);
		if (max == min) {
			System.out.println("입력한 수 들은 같습니다.");
			return;
		}
		System.out.println("max = " + max + "\nmin = " + min);
	}

	public static int[] input() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		System.out.print("다섯 개의 정수를 입력하시오>");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();
		return arr;

	}

	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = max < arr[i] ? arr[i] : max;
		}
		return max;
	}

	public static int min(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			min = min > arr[i] ? arr[i] : min;
		}
		return min;
	}

}
