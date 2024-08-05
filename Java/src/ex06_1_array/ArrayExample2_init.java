package ex06_1_array;

public class ArrayExample2_init {

	public static void main(String[] args) {
		
		int[] arr;
		arr = new int[10];
		// 배열의 공간에 일일이 변수를 초기화해줄 필요 없이 
		// for 문으로 한번에 초기화 및 배열 값을 출력할 수 있다
		for (int i = 0 ; i < 10; i++) {
			//arr[i] = i;
			System.out.println("arr[" + i + "]= " + arr[i]);
		}
		
		//arr.length 를 이용하여 따로 지정해줄 필요없이 배열의 길이를 집어넣을 수 있다.
		for (int i = 0 ; i < arr.length ; i++) {
			
			System.out.println("arr[" + i + "]= " + arr[i]);
		}
		
	}
}
