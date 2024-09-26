package ex06_2_method;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		int[] arr = input();
		int[] maxMin = max_min(arr);
		int max = maxMin[0];
		int min = maxMin[1];
		if (max == min) {
			System.out.println("입력한 수들은 같습니다.");
			return;
		}
		System.out.println("max = " + max + "\nmin = " + min);
	}

	public static int[] input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 정수의 갯수를 입력하시오>");
		int list = sc.nextInt();
		int[] arr = new int[list];
		System.out.print(list + " 개의 정수를 입력하시오>");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();
		return arr;
	}

	public static int[] max_min(int[] arr) {
		int[] maxMin = {arr[0], arr[0]}; //[0] 이 max [1] 이 min
		//maxMin[0] = arr[0];
		//maxMin[1] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxMin[0] = maxMin[0] < arr[i] ? arr[i] : maxMin[0];
			maxMin[1] = maxMin[1] > arr[i] ? arr[i] : maxMin[1];
		}

		return maxMin;
	}

}
