package ex06_1_array;

public class ArrayExample2_init2 {

	public static void main(String[] args) {
		//방법 1
		System.out.println("===== 방법 1 =====");
		int arr[];
		arr = new int[5];
		// 배열의 공간에 일일이 변수를 초기화해줄 필요 없이 
		// for 문으로 한번에 초기화 및 배열 값을 출력할 수 있다
		// arr.length 를 이용하여 따로 지정해줄 필요없이 배열의 길이를 집어넣을 수 있다.
		arr[0]=10; arr[1]=20; arr[2]=30; arr[3]=40; arr[4]=50;
		for (int i = 0 ; i < arr.length ; i++) {
			//arr[i] = (i+1) * 10;
			System.out.println("arr[" + i + "]= " + arr[i]);
		}
		//방법 2
		System.out.println("===== 방법 2 =====");
		
		int[] arr2 = new int[5];
		arr2[0]=10; arr2[1]=20; arr2[2]=30; arr2[3]=40; arr2[4]=50;
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println("arr2[" + i + "]= " + arr2[i]);
		}
		
		//방법 3
		System.out.println("===== 방법 3 =====");
		
		int arr3[] = {10,20,30,40,50};
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println("arr3[" + i + "]= " + arr3[i]);
		}
	}
}
