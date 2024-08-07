package ex15_4_hashmap_treemap;

import java.util.*;

public class Ex4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		System.out.print("다섯 개의 정수를 입력하시오>");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		HashMap<String, Integer> hm = max_min(arr);
		// 반환 받은 hashMap hm

		System.out.println("최솟값 = " + hm.get("min")); // 키값 이용해서 출력
		System.out.println("최댓값 = " + hm.get("max"));
		sc.close();
	}

	static HashMap<String, Integer> max_min(int arr[]) {

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("min", arr[0]);
		hm.put("max", arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (hm.get("max") < arr[i]) {
				hm.put("max", arr[i]);
			}
			if (hm.get("min") > arr[i]) {
				hm.put("min", arr[i]);
			}
		}

		/*
		 * //원래 있던 코드 재활용 
		 * int[] result = new int[2]; 
		 * result[0] = arr[0]; //최대
		 * result[1]= arr[0]; //최소 
		 * for (int i = 1 ; i < arr.lentgh ; i++) { 
		 * result[0] = result[0] < arr[i] ? arr[i] : result[0]; 
		 * result[1] = result[0] > arr[i] ? arr[i] : result[1]; 
		 * } 
		 * //반환할 때 hashMap에 put 
		 * hm.put("min",result[1]);
		 * hm.put("max",result[0]);
		 */
		return hm;

	}
}