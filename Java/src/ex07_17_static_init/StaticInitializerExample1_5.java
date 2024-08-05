package ex07_17_static_init;

public class StaticInitializerExample1_5 {

	public static void main(String[] args) {
		System.out.println("main 실행 시작");
		
		HundredNumbers3 h = new HundredNumbers3("호호");
		System.out.println(h.a);
	}
}

