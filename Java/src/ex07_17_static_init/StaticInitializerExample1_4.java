package ex07_17_static_init;

public class StaticInitializerExample1_4 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("main 실행 시작");
		
		//배열에 있는 항목들 중 3개의 항목을 가져와서 그 값을 출력한다.
		System.out.println(HundredNumbers2.arr[35]);
		System.out.println(HundredNumbers2.arr[27]);
		System.out.println(HundredNumbers2.arr[63]);
		
		HundredNumbers2 h = new HundredNumbers2();
		HundredNumbers2 h2 = new HundredNumbers2();
	}
}
