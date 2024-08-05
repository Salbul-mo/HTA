package ex06_1_array;

public class Enhanced_ForExample2 {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50 };

		for (int num : arr) {
			System.out.println(num);
		}
		//향상된 for문, 배열 처음부터 끝까지 돌때 사용한다.(jdk 1.5 이상)
		//하지만 특정 i값이 필요한 경우에는 향상된 for문을 사용할 수 없다.
		System.out.println("END.");
		
		
	}
}
