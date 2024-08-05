package ex06_2_method;

public class MethodExample12 {

	public static void main(String[] args) {

		int[] num = { 1, 2, 3, 4, 5 };
		print(num);
		return; // 여기서 main() 메서드를 종료한다.
	}
	
	public static void print(int[] p_num) {
		for (int i : p_num) 
			System.out.print(i+" ");
		return; //여기서 print() 종료한다.
	}

}
