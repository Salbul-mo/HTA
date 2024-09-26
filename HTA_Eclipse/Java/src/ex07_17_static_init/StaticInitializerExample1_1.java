package ex07_17_static_init;

public class StaticInitializerExample1_1 {

	public static void main(String[] args) {
		System.out.println("main 실행 시작");
		
		//배열에 있는 항목들 중 3개의 항목을 가져와서 그 값을 출력한다.
		System.out.println(HundredNumbers.arr[35]);
		System.out.println(HundredNumbers.arr[27]);
		System.out.println(HundredNumbers.arr[63]);
	}
}
