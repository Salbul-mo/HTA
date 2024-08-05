package ex06_1_array;

public class ArrayExample1 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		//또는 int arr[]도 상관없다.
		//new 는 heap 영역에 생성된다고 알아두자.
		
		double[] arr2 = new double[10];
		String[] arr3 = new String[10];
		
		arr3[0] = "10";
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = arr[0] + arr[1];
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[9]);
		
		// 반드시 보게될 오류 Index out of bounds for length
		// java.lang.ArrayIndexOutOfBoundsException
		System.out.println(arr[10]);
	}
}
